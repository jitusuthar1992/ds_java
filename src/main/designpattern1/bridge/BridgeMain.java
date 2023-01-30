package main.designpattern1.bridge;

import main.designpattern1.bridge.impl.Email;
import main.designpattern1.bridge.impl.QRMessage;
import main.designpattern1.bridge.impl.SMS;
import main.designpattern1.bridge.impl.TextMessage;

public class BridgeMain {
    public static void main(String[] args) {
        Notification notification = new TextMessage(new Email());
        notification.sendMessage();
        notification = new QRMessage(new SMS());
        notification.sendMessage();
    }
}
