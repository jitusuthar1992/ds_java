package main.designpattern1.decorator;

public abstract class Beverage {
    String beverageName="";

    public String getBeverageName() {
        return beverageName;
    }
    abstract int getPrice();
}
