package main.design_pattern.behavioral.observer;

public interface Observer {
    void setSubject(Subject subject);
    void update();
}
