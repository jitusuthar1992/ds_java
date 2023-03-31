package main.design_pattern.behavioral.mediator;

public interface ChatMediator {
    void sendMessage(User user , String msg);
    void addUser(User user);
}
