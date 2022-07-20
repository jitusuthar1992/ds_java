package main.designpattern.decorator.beverageproblem;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Mocha";
    }

    @Override
    public Double cost() {
        return 0.20 + beverage.cost();
    }
}
