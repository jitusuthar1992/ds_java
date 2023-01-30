package main.designpattern1.decorator;

public class CoffeeHouse {
    public static void main(String[] args) {
        Beverage capaccino = new Capaccino();
        capaccino = new Milk(capaccino);
        System.out.println("After decorating with milk");
        System.out.println("Beverage Name "+ capaccino.getBeverageName());
        System.out.println("Pricr "+capaccino.getPrice());

    }
}
