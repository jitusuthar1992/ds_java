package main.command.pattern.impl1;

import main.command.pattern.impl.CeilingFan;
import main.command.pattern.impl.SimpleRemoteControl;

public class CeilingFanOffCommand implements SimpleRemoteControl.Command {
    CeilingFan fan;
    int        prevSpeed;

    public CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        if(prevSpeed == CeilingFan.HIGH){
            fan.high();
        }else if (prevSpeed == CeilingFan.MEDIUM){
            fan.medium();
        }else if(prevSpeed == CeilingFan.LOW){
            fan.low();
        }else{
            fan.off();
        }

    }
}
