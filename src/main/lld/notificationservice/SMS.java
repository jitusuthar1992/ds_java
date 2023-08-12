package main.lld.notificationservice;

public class SMS extends NotificationSender{
    @Override
    public void sendNotification() {
        System.out.println("We are going to send a SMS");
    }
}
