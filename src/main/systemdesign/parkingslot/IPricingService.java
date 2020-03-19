package main.systemdesign.parkingslot;

import main.systemdesign.parkingslot.constant.VehicleType;

import java.util.Date;

public interface IPricingService {
    double calculatePrice(Date entryTime, Date exitTime , VehicleType vehicleType);
}
