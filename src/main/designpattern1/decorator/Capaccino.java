package main.designpattern1.decorator;

public class Capaccino extends Beverage{
    public Capaccino() {
        beverageName ="Capaccino";
    }

    @Override
    int getPrice() {
        return 50;
    }
}
