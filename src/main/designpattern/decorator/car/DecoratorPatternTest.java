package main.designpattern.decorator.car;

import main.designpattern.decorator.car.decorator.impl.LuxuryCar;
import main.designpattern.decorator.car.decorator.impl.SportsCar;
import main.designpattern.decorator.car.impl.BasicCar;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        LuxuryCar luxuryCar = new LuxuryCar(new SportsCar(new BasicCar()));
        luxuryCar.assemble();
    }
}
