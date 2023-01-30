package main.designpattern1.bridge.impl;

import main.designpattern1.bridge.Notification;
import main.designpattern1.bridge.NotificationSender;

public class TextMessage extends Notification {

    public TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a Text Message");
    }

    @Override
    public void sendMessage() {
        notificationSender.sendNotification();
    }
}
