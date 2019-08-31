package main.designpattern.adapterpattern.impl;

import main.designpattern.adapterpattern.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobblr gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
