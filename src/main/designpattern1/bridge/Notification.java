package main.designpattern1.bridge;

public abstract class Notification {
    protected NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }
    public abstract  void sendMessage();
}
