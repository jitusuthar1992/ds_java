package main.java1.java8;

/**
 * @author jitendra.kumar01
 * 27/01/20
 */
public interface DefaultMethodInterface {
    default void move() {
        System.out.println("I am moving");
    }
}
