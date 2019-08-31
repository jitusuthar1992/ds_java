package main.designpattern.adapterpattern.impl;

import main.designpattern.adapterpattern.Duck;
import main.designpattern.adapterpattern.Turkey;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter() {
    }

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i <5 ; i++) {
            turkey.fly();
        }
    }
}
