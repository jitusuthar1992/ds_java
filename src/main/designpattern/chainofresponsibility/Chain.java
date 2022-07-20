package main.designpattern.chainofresponsibility;

public abstract class Chain {
    public abstract void setNext(Chain next);

    public abstract void process(Dimension dimension);
}
