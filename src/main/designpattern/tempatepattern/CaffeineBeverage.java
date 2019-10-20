package main.designpattern.tempatepattern;

abstract public class CaffeineBeverage {
    abstract void brew();
    abstract void addCondiments();

    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater(){
        System.out.println("Boiling Water");
    }

    void pourInCup(){
        System.out.println("Pouring In Cup");
    }
}

class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("Brew coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Add milk and sugar to coffee");
    }
}

class Tea extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("brew tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Add milk and sugar to tea");
    }
}