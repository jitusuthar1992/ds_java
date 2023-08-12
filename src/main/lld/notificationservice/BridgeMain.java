package main.lld.notificationservice;

public class BridgeMain {
    public static void main(String[] args) {
        TextMessage textMessage = new TextMessage(new Email());
        textMessage.sendMessage();

        textMessage = new TextMessage(new SMS());
        textMessage.sendMessage();
    }
}
