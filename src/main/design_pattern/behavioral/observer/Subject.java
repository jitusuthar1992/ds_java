package main.design_pattern.behavioral.observer;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer Observer);
    void notifyObservers();
    Object getUpdate(Observer obj);
}
