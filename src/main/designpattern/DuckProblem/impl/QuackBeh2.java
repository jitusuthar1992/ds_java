package main.designpattern.DuckProblem.impl;

import main.designpattern.DuckProblem.QuackBehaviour;

public class QuackBeh2 implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("QuackBeh1");
    }
}
