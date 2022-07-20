package main.designpattern.adapterpattern.impl;

import main.designpattern.adapterpattern.Duck;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("run");
                }

            }
        }.start();
        System.out.println("main");
    }
}
