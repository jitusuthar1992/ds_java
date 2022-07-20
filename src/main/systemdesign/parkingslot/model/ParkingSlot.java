package main.systemdesign.parkingslot.model;

import main.systemdesign.parkingslot.constant.State;
import main.systemdesign.parkingslot.constant.VehicleType;

public class ParkingSlot {
    long id;
    VehicleType vehicleType;
    State state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
