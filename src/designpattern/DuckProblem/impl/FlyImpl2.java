package designpattern.DuckProblem.impl;

import designpattern.DuckProblem.FlyBehaviour;

public class FlyImpl2 implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("FlyImpl2");
    }
}
