package main.java1.coupling.loose;

public class LooseCoupling {
    public static void main(String[] args) {
       Subject subject  = new Subject(new Topic1());
       subject.startReading();
    }
}
class Subject {
    private Topic topic;
    public Subject(Topic topic) {
        this.topic = topic;
    }

    public void startReading(){
        System.out.println("Start Reading");
        topic.underStand();
    }
}

interface Topic {
    void underStand();
}

class Topic1 implements Topic {
    public void underStand(){
        System.out.println("Understanding Topic1");
    }
}
class Topic2 implements Topic {
    public void underStand(){
        System.out.println("Understanding Topic2");
    }
}
