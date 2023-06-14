package main.designpattern.decorator.coffeemaker.impl;

import main.designpattern.decorator.coffeemaker.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getIngredients() {
        return "Plain Coffee";
    }
}
