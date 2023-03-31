package main.design_pattern.behavioral.mediator;

import java.util.Objects;

public abstract class User {
    String name;
    ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public abstract void sendMessage(String msg);
    public abstract void receiveMessage(String msg);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(chatMediator, user.chatMediator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chatMediator);
    }
}
