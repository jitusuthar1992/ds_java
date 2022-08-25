package main.java1.multithreading;

/**
 * @author jitendra.kumar01
 * 22/02/20
 */
public class DiamondProblemWithInterface extends Parent implements PI1, PI2 {
    public static void main(String args[]) {
        Parent d = new DiamondProblemWithInterface();
        d.show();
    }

    @Override
    public void show() {
        PI1.super.show();
        PI2.super.show();
    }
}

class Parent {
    void show() {
        System.out.println("Default class PI1");
    }
}

interface PI1 {
    // default method
    default void show() {
        System.out.println("Default PI1");
    }
}

interface PI2 {
    // Default method
    default void show() {
        System.out.println("Default PI2");
    }
}
