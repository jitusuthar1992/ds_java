package main.design_pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject{
    private List<Observer> observers ;
    private String msg;
    private boolean changed;

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    private Object mutex = new Object();
    @Override
    public void register(Observer observer) {
        if(null == observer) throw new NullPointerException("Null Observer");
        synchronized (mutex){
            if(!observers.contains(observer)){
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer Observer) {
        synchronized (mutex){
            observers.remove(Observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersList =null;
        synchronized (mutex){
            if(!changed)
                return;
            observersList = new ArrayList<>(observers);
            this.changed = false;
        }
        for (int i = 0; i < observersList.size(); i++) {
            observersList.get(i).update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.msg;
    }

    public void postMessage(String message){
        this.msg = message;
        this.changed = true;
        notifyObservers();
    }
}
