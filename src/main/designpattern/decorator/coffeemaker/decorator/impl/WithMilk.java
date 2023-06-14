package main.designpattern.decorator.coffeemaker.decorator.impl;

import main.designpattern.decorator.coffeemaker.Coffee;
import main.designpattern.decorator.coffeemaker.decorator.CoffeeDecorator;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee coffee) {
        super(coffee);
    }

    public int getCost(){
        return super.getCost()+2;
    }

    public String getIngredients(){
        return super.getIngredients()+" ,with Milk";
    }
}
