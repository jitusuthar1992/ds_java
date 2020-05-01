package main.designpattern.command.impl1;

import main.designpattern.command.impl.SimpleRemoteControl;

public class CeilingFanMediumCommand implements SimpleRemoteControl.Command {
    CeilingFan fan;
    int        prevSpeed;

    public CeilingFanMediumCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.medium();
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
