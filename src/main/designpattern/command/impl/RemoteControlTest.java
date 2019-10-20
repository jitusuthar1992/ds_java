package main.designpattern.command.impl;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand command = new LightOnCommand(light);
        control.setCommand(command);
        control.buttonWasPressed();
    }
}
