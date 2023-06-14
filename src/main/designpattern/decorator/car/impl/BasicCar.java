package main.designpattern.decorator.car.impl;

import main.designpattern.decorator.car.Car;

public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car Assembled.");
    }
}
