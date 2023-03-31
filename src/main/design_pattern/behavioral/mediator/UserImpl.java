package main.design_pattern.behavioral.mediator;

public class UserImpl extends User{

    public UserImpl(String name, ChatMediator chatMediator) {
        super(name, chatMediator);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(this.name+": Sending Message="+msg);
        chatMediator.sendMessage(this, msg);
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println(this.name+": Received Message:"+msg);
    }
}
