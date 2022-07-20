package main.designpattern.chainofresponsibility;

import java.util.Arrays;

public class ThreeDimension extends Chain {

    private Chain nextChain;

    @Override
    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void process(Dimension dimension) {
        if (dimension.getCoordinates().length == 3) {
            System.out.println("Three Dimension Cooridinates :" + Arrays.toString(dimension.getCoordinates()));
        } else {
            // nextChain.process(dimension);
        }
    }
}
