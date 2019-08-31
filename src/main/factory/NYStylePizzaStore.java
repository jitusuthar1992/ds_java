package main.factory;

public class NYStylePizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        if("cheese".equalsIgnoreCase(type)){
             pizza = new NYStyleCheesePizza();
        }else if("clam".equalsIgnoreCase(type)){
            pizza = new NYStyleCheesePizza();
        }
        return pizza;
    }
}
