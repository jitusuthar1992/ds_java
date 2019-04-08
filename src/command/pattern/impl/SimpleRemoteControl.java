package command.pattern.impl;

import command.pattern.Command;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }
    public void setCommand(Command command){
        slot=command;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}
