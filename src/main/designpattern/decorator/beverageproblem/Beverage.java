package main.designpattern.decorator.beverageproblem;

public abstract class Beverage {
    public String description = "Unknown Description";

    public String getDescription() {
        return description;
    }

    public abstract Double cost();
}
