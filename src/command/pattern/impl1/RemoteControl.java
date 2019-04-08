package command.pattern.impl1;

import command.pattern.Command;

public class RemoteControl {
    Command[] onCommand;
    Command[] offCommand;

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
    }

    public void offButtonWasPressed(int slot){
        offCommand[slot].execute();
    }

}
