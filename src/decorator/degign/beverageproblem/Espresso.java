package decorator.degign.beverageproblem;

import decorator.degign.beverageproblem.Beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description="Espresso Coffee";
    }

    @Override
    public Double cost() {
        return 1.00;
    }
}
