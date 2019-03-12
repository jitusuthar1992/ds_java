package designpattern.DuckProblem.impl;

import designpattern.DuckProblem.QuackBehaviour;

public class QuackBeh1 implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("QuackBeh1");
    }
}
