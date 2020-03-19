package main.systemdesign.parkingslot.impl;

import main.systemdesign.parkingslot.IParkingService;
import main.systemdesign.parkingslot.constant.VehicleType;
import main.systemdesign.parkingslot.model.Ticket;

public class ParkingService implements IParkingService {
    @Override
    public Ticket entry(VehicleType vehicleType) {
        return null;
    }

    @Override
    public double exit(long ticketId) {
        return 0;
    }
}
