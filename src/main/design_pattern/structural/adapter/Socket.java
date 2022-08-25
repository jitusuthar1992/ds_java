package main.design_pattern.structural.adapter;

import java.util.ArrayList;

public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
