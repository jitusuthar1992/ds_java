package main.designpattern.tempatepattern;

public class TestBeverage {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        myTea.prepareRecipe();
        System.out.println("####################");
        Coffee myCoffee = new Coffee();
        myCoffee.prepareRecipe();
    }
}
