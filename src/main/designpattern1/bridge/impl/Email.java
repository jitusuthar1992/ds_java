package main.designpattern1.bridge.impl;

import main.designpattern1.bridge.NotificationSender;

public class Email implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("We are going to send Email");
    }
}
