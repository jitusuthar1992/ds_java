package main.design_pattern.structural.adapter;

public class Volt {

    private int volts;
    public Volt() {
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    public Volt(int volts) {
        this.volts = volts;
    }
}
