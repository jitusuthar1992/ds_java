package main.designpattern1.strategy.impl;

import main.designpattern1.strategy.Device;
import main.designpattern1.strategy.Resolution;
import main.designpattern1.strategy.VideoPlayer;

public class TVVideoPlayer extends VideoPlayer {

    public TVVideoPlayer(Device device, Resolution resolution) {
        this.device = device;
        this.resolution = resolution;
    }

    @Override
    public void display() {
        this.getDevice();
        this.getResolution();
    }
}
