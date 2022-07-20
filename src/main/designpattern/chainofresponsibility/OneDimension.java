package main.designpattern.chainofresponsibility;

import java.util.Arrays;

public class OneDimension extends Chain {

    private Chain nextChain;

    @Override
    public void setNext(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void process(Dimension dimension) {
        if (dimension.getCoordinates().length == 1) {
            System.out.println("One Dimension Cooridinates :" + Arrays.toString(dimension.getCoordinates()));
        } else {
            nextChain.process(dimension);
        }
    }
}
