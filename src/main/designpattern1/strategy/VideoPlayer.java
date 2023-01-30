package main.designpattern1.strategy;

public abstract class VideoPlayer {
    protected Device device;
    protected Resolution resolution;

    public void getDevice() {
        device.display();
    }

    public void getResolution() {
        resolution.resolution();
    }

    public abstract void display();
}
