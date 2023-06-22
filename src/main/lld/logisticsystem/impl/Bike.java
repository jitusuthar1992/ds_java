package main.lld.logisticsystem.impl;

import main.lld.logisticsystem.model.Vehicle;

public class Bike extends Vehicle {

    private final static int capacityofBike = 10;

    public Bike(int id, String vehicleNo)
    {

        super(id, vehicleNo, capacityofBike);
    }
}