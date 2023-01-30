package main.designpattern1.bridge.impl;

import main.designpattern1.bridge.Notification;
import main.designpattern1.bridge.NotificationSender;

public class QRMessage extends Notification {
    public QRMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a QR Message");
    }

    @Override
    public void sendMessage() {
        notificationSender.sendNotification();
    }
}
