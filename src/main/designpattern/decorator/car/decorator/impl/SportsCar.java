package main.designpattern.decorator.car.decorator.impl;

import main.designpattern.decorator.car.Car;
import main.designpattern.decorator.car.decorator.CarDecorator;

public class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}
