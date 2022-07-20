package main.designpattern.command.impl1;

import main.designpattern.command.impl.Light;
import main.designpattern.command.impl.SimpleRemoteControl;

public class LightOffCommand implements SimpleRemoteControl.Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
