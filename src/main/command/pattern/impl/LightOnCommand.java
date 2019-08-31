package main.command.pattern.impl;

public class LightOnCommand implements SimpleRemoteControl.Command {

    Light light;
    public LightOnCommand(Light light ) {
        this.light=light;
    }

    @Override
    public void execute() {
        light.on();

    }

    @Override
    public void undo() {
        light.off();
    }
}