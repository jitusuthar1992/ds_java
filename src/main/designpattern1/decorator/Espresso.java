package main.designpattern1.decorator;

public class Espresso extends Beverage{
    public Espresso() {
        beverageName ="Espresso";
    }

    @Override
    int getPrice() {
        return 20;
    }
}
