package main.designpattern.adapterpattern.impl;

import main.designpattern.adapterpattern.Duck;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("The Turkey Says....");
        turkey.gobble();
        turkey.fly();

        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
