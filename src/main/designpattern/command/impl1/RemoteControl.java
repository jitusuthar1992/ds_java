package main.designpattern.command.impl1;

import main.designpattern.command.impl.SimpleRemoteControl;

public class RemoteControl {
    SimpleRemoteControl.Command[] onCommand;
    SimpleRemoteControl.Command[] offCommand;
    SimpleRemoteControl.Command undoCommand;

    public RemoteControl() {
        offCommand = new SimpleRemoteControl.Command[7];
        onCommand = new SimpleRemoteControl.Command[7];
        NoComand noComand = new NoComand();
        for (int i = 0; i < 7; i++) {
            offCommand[i] = noComand;
            onCommand[i] = noComand;
        }
    }

    public void setCommand(int slot, SimpleRemoteControl.Command off, SimpleRemoteControl.Command on) {
        onCommand[slot] = on;
        offCommand[slot] = off;
    }

    public void onButtonWasPressed(int slot) {
        onCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommand[slot].execute();
        undoCommand = offCommand[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

}
