package designpattern.DuckProblem.impl;

import designpattern.DuckProblem.FlyBehaviour;

public class FlyImpl1 implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("FlyImpl1");
    }
}
