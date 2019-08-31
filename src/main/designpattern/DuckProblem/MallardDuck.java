package main.designpattern.DuckProblem;

import main.designpattern.DuckProblem.impl.Duck;
import main.designpattern.DuckProblem.impl.FlyImpl1;
import main.designpattern.DuckProblem.impl.QuackBeh1;

public class MallardDuck extends Duck {


    public MallardDuck() {
        quackBehaviour = new QuackBeh1();
        flyBehaviour = new FlyImpl1();
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck");
    }

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.swim();
        duck.quack();
        duck.fly();
        duck.display();
    }
}
