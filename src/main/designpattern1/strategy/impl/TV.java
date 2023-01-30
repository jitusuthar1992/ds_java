package main.designpattern1.strategy.impl;

import main.designpattern1.strategy.Device;

public class TV implements Device {
    @Override
    public void display() {
        System.out.println("Playing the video in TV");
    }
}
