package main.systemdesign.parkingslot;

import main.systemdesign.parkingslot.constant.VehicleType;
import main.systemdesign.parkingslot.model.ParkingSlot;

public interface ISlotService {
    ParkingSlot allocate(VehicleType vehicleType);

    boolean unAllocate(long slotId);
}
