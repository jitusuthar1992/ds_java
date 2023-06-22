package main.lld.parkinglot.model;


public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    private Ticket(String ticketNumber, long startTime, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketNumber = ticketNumber;
        this.startTime = startTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        return new Ticket(vehicle.getVehicleNumber()+System.currentTimeMillis(),System.currentTimeMillis(),vehicle,parkingSlot );
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
