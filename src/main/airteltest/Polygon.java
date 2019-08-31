package main.airteltest;

import java.util.List;

abstract public class Polygon {
    private List<Double> sides;


    public Polygon() {
    }
    public Polygon(List<Double> sides) {
        this.sides = sides;
    }

    public List<Double> getSides() {
        return sides;
    }

    public void setSides(List<Double> sides) {
        this.sides = sides;
    }

    abstract public Double getArea();

}
