package main.designpattern.command.impl;

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

    public static interface Command {
        void execute();
        void undo();
    }
}
