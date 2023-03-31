package main.design_pattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(User user, String msg) {
        for (User u : users) {
            if(u != user ){
                u.receiveMessage(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
