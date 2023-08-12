package main.lld.notificationservice;

public abstract class Notification {
    NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public abstract void sendMessage();
}
