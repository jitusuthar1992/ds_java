package main.designpattern.decorator.car.decorator;

import main.designpattern.decorator.car.Car;

public class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
