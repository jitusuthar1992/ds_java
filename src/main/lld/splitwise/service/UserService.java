package main.lld.splitwise.service;

import main.lld.splitwise.model.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public Optional<User> getUser(String userName){
        return users.stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }
}
