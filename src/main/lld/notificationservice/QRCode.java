package main.lld.notificationservice;

public class QRCode extends Notification{
    public QRCode(NotificationSender notificationSender) {
        super(notificationSender);
    }

    @Override
    public void sendMessage() {
        notificationSender.sendNotification();
        System.out.println("This is a QR Code");
    }
}
