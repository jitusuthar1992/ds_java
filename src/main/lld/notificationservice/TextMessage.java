package main.lld.notificationservice;

public class TextMessage extends Notification {

    public TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
    }

    @Override
    public void sendMessage() {
        notificationSender.sendNotification();
        System.out.println("This is the text message");
    }
}
