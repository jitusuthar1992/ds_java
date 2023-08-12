package main.lld.notificationservice;

public class Email extends NotificationSender{
    @Override
    public void sendNotification() {
        System.out.println("We are going to send an EMAIL");
    }
}
