package main.designpattern1.decorator;

public class Milk extends IngredientDecorator{

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    int getPrice() {
        return beverage.getPrice() +10;
    }

    @Override
    public String getBeverageName() {
        return beverage.getBeverageName()+ " with Milk";
    }
}
