package main.designpattern.command.impl1;

import main.designpattern.command.impl.CeilingFan;
import main.designpattern.command.impl.Light;
import main.designpattern.command.impl.LightOnCommand;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        control.setCommand(0,lightOffCommand,lightOnCommand);
        control.offButtonWasPressed(0);
        control.onButtonWasPressed(0);
        control.undoButtonWasPressed();

        CeilingFan fan = new CeilingFan("Ceiling Fan");
        CeilingFanHighCommand fanHighCommand = new CeilingFanHighCommand(fan);
        CeilingFanMediumCommand fanMediumCommand = new CeilingFanMediumCommand(fan);
        CeilingFanOffCommand fanOffCommand = new CeilingFanOffCommand(fan);
        control.setCommand(1,fanHighCommand,fanOffCommand);
        control.onButtonWasPressed(1);
        control.undoButtonWasPressed();
        control.setCommand(2,fanMediumCommand,fanOffCommand);
        control.onButtonWasPressed(2);
        control.undoButtonWasPressed();
    }
}
