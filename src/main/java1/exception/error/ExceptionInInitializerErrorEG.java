package main.java1.exception.error;

/**
 * @author jitendra.kumar01
 * 24/02/20
 */
public class ExceptionInInitializerErrorEG {
    static {
        int[] c = new int[3];
        int num = c[-1];
    }


    public static void main(String[] args) {
        /*int[] c = new int[3];
        int num = c[-1];*/
    }
}
