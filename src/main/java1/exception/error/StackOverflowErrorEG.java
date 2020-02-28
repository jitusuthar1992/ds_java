package main.java1.exception.error;

/**
 * @author jitendra.kumar01
 * 24/02/20
 */
public class StackOverflowErrorEG {

    public static void call(int n)
    {
        call(8);
    }
    public static void main(String[] args) {
        call(8);
    }
}
