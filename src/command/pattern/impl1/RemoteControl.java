package command.pattern.impl1;

import command.pattern.Command;

public class RemoteControl {
    Command[] onCommand;
    Command[] offCommand;
    Command undoCommand;

    public RemoteControl() {
        offCommand = new Command[2];
        onCommand = new Command[2];
        NoComand noComand = new NoComand();
        for (int i= 0;i < 2;i++){
            offCommand[i] = noComand;
            onCommand[i] = noComand;
        }
    }

    public void setCommand(int slot ,Command off , Command on){
        onCommand[slot] =on;
        offCommand[slot] = off;
    }
    public void onButtonWasPressed(int slot){
        onCommand[slot].execute();
        undoCommand = onCommand[slot];
    }

    public void offButtonWasPressed(int slot){
        offCommand[slot].execute();
        undoCommand = offCommand[0];
    }

    public void undoButtonWasPressed(){
        undoCommand.undo();
    }

}
