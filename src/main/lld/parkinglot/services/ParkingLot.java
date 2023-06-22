package main.lld.parkinglot.services;

import main.lld.parkinglot.model.Address;
import main.lld.parkinglot.model.ParkingSlot;
import main.lld.parkinglot.model.Ticket;
import main.lld.parkinglot.model.Vehicle;

import java.util.List;

public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;
    List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }
    public static ParkingLot getInstance(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors ){
        if(parkingLot == null){
            parkingLot = new ParkingLot(nameOfParkingLot,address,parkingFloors);
        }
        return parkingLot;
    }

    public void addFloors(ParkingFloor parkingFloor){
        parkingFloors.add(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null)
            return null;
        Ticket ticket = createTicketForSlot(parkingSlot,vehicle);
        //persist ticket to database
        return ticket;
    }

    private synchronized ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for (ParkingFloor floor: parkingFloors) {
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(null != parkingSlot)
                break;
        }
        return parkingSlot;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle,parkingSlot);
    }

    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int)(endTime-ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        // persist price to database;
        return price;
    }
}
