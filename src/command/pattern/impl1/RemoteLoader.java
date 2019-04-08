package command.pattern.impl1;

import command.pattern.impl.Light;
import command.pattern.impl.LightOnCommand;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        control.setCommand(0,lightOffCommand,lightOnCommand);
        control.offButtonWasPressed(0);
        control.onButtonWasPressed(0);
    }
}
