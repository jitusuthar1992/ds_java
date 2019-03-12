package designpattern.DuckProblem;

import designpattern.DuckProblem.impl.Duck;
import designpattern.DuckProblem.impl.FlyImpl1;
import designpattern.DuckProblem.impl.QuackBeh1;

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
