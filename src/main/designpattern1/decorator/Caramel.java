package main.designpattern1.decorator;

public class Caramel extends IngredientDecorator{
    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    int getPrice() {
        return beverage.getPrice() + 5;
    }

    @Override
    public String getBeverageName() {
        return beverage.getBeverageName() + " with Caramel";
    }
}
