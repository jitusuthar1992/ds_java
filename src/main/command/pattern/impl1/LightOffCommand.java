package main.command.pattern.impl1;

import main.command.pattern.impl.Light;
import main.command.pattern.impl.SimpleRemoteControl;

public class LightOffCommand implements SimpleRemoteControl.Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light= light;
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
