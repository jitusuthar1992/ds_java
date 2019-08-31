package main.airteltest;

import java.util.ArrayList;
import java.util.List;

public class TestPolyGon {
    public static void main(String[] args) {
        List<Double> sides = new ArrayList<>();
        sides.add(1.1);
        sides.add(2.1);
        Polygon polygon = new Square(sides,1.1,2.1);
        System.out.println(polygon.getArea());
        polygon  = new Rectangle(sides,1.1,2.1);
        System.out.println(polygon.getArea());
    }
}
