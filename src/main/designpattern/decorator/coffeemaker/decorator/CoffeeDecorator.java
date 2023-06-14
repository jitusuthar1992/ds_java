package main.designpattern.decorator.coffeemaker.decorator;

import main.designpattern.decorator.coffeemaker.Coffee;

public class CoffeeDecorator implements Coffee {

    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost();
    }

    @Override
    public String getIngredients() {
        return this.coffee.getIngredients();
    }
}
