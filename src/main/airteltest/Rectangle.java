package main.airteltest;

import java.util.List;

public class Rectangle extends Polygon {

    private Double side1, side2;

    public Rectangle(Double side1, Double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(List<Double> sides, Double side1, Double side2) {
        super(sides);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double getArea() {
        return (side1 * side2);
    }
}
