package main.designpattern.factory;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore store = new NYStylePizzaStore();
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("ordered pizza :" +pizza.getName());
    }
}
