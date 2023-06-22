package main.lld.parkinglot.services;

import main.lld.parkinglot.model.ParkingSlot;
import main.lld.parkinglot.model.ParkingSlotType;
import main.lld.parkinglot.model.Vehicle;
import main.lld.parkinglot.model.VehicleCategory;

import java.util.Map;

public class ParkingFloor {
    String name;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<ParkingSlotType, Map<String, ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String,ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;

        for (ParkingSlot parkingSlot : relevantParkingSlot.values()){
            if(parkingSlot.isAvailable()){
                slot = parkingSlot;
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        switch (vehicleCategory){
            case TwoWheeler:
                return ParkingSlotType.TwoWheeler;
            case Sedan:
            case Hatchback:
                return ParkingSlotType.Compact;
            case SUV:
                return ParkingSlotType.Medium;
            case Bus:
                return ParkingSlotType.Large;
        }
        return null;
    }
}
