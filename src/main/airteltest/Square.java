package main.airteltest;

import java.util.List;

public class Square extends Rectangle {

    private Double side;

    public Square(List<Double> sides, Double side1, Double side2) {
        super(sides, side1, side2);
        this.side = side1;
    }

    public Double getArea(){
        return (side*side);
    }
}
