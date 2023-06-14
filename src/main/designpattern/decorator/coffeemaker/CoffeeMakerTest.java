package main.designpattern.decorator.coffeemaker;

import main.designpattern.decorator.coffeemaker.decorator.impl.WithMilk;
import main.designpattern.decorator.coffeemaker.impl.SimpleCoffee;

public class CoffeeMakerTest {
    public static void main(String[] args) {
        Coffee plainCoffee= new SimpleCoffee();
        System.out.println("Plain Coffee Cost : "+plainCoffee.getCost());
        System.out.println("Plain Coffee Ingredients : "+plainCoffee.getIngredients());

        Coffee coffeeWithMilk = new WithMilk(plainCoffee);

        System.out.println("With Milk Coffee Cost : "+coffeeWithMilk.getCost());
        System.out.println("With Milk Coffee Ingredients : "+coffeeWithMilk.getIngredients());
    }
}
