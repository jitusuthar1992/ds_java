package main.design_pattern.behavioral.observer;

public class Subscriber implements Observer{

    private String name ;
    private Subject topic;

    public Subscriber(String name) {
        this.name = name;
    }


    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
    }

    @Override
    public void update() {
        String msg = (String) this.topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }
}
