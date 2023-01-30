package main.designpattern1.strategy.impl;

import main.designpattern1.strategy.Resolution;

public class P720 implements Resolution {
    @Override
    public void resolution() {
        System.out.println("Playing the video in 720P");
    }
}
