package main.systemdesign.parkingslot;

import main.systemdesign.parkingslot.constant.VehicleType;
import main.systemdesign.parkingslot.model.Ticket;

public interface IParkingService {
    Ticket entry(VehicleType vehicleType);
    double exit(long ticketId);
}
