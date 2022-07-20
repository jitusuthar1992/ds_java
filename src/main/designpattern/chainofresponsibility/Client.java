package main.designpattern.chainofresponsibility;

public class Client {

    public static void main(String[] args) {
        Chain c1 = new OneDimension();
        Chain c2 = new TwoDimension();
        Chain c3 = new ThreeDimension();

        c1.setNext(c2);
        c2.setNext(c3);

        c1.process(new Dimension(3, 4, 4));

    }

}
