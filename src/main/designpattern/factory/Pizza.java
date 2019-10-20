package main.designpattern.factory;

import java.util.ArrayList;

public  class Pizza {
    String name ;
    String dough;
    String sauce;

    ArrayList toppings = new ArrayList();

    void prepare(){
        System.out.println("Preparing "+name);
        System.out.println("Tossing Dough..."+dough);
        System.out.println("Adding Sauce : "+sauce);
        System.out.println("Adding Toppings: ");
        for (int i = 0; i <toppings.size() ; i++) {
            System.out.println("  "+toppings.get(0));

        }
    }

    void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box(){
        System.out.println("Place pizza ib official PizzaStore Box");
    }
    public String getName(){
        return name;
    }

}
