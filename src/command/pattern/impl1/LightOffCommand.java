package command.pattern.impl1;

import command.pattern.Command;
import command.pattern.impl.Light;

public class LightOffCommand implements Command {
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
