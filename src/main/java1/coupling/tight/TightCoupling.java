package main.java1.coupling.tight;

public class TightCoupling {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.startReading();
    }

}

class Subject {

    public void startReading() {
        Topic topic = new Topic();
        System.out.println("Start Reading");
        topic.underStand();
    }
}

class Topic {
    public void underStand() {
        System.out.println("Understanding Topic");
    }
}
