package main.design_pattern.behavioral.observer;

public class Test {
    public static void main(String[] args) {
        MyTopic topic = new MyTopic();
        Observer obs1 = new Subscriber("Test1");
        Observer obs2 = new Subscriber("Test2");
        Observer obs3 = new Subscriber("Test3");
        topic.register(obs1);
        topic.register(obs2);
        topic.register(obs3);
        obs1.setSubject(topic);
        obs2.setSubject(topic);
        obs3.setSubject(topic);

        obs1.update();

        topic.postMessage("new message");
    }
}
