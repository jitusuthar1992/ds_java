package main.design_pattern.behavioral.mediator;

public class ChatApp {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User user = new UserImpl("Amit",chatMediator);

        User user1 = new UserImpl("Rajesh",chatMediator);

        User user2 = new UserImpl("Piyush",chatMediator);

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user);

        user.sendMessage("Test Message");
    }
}
