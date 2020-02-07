package main.java1.javaPuzzles;

/**
 * @author jitendra.kumar01
 * 02/02/20
 */
public class DeadCode {
    public void howToDoInJava_method1() {
        System.out.println("how to do");
        return;
       // System.out.println("in java");
    }

    public void howToDoInJava_method2() {
        System.out.println("how to do");
        if (true) {
            return;
        }
        System.out.println("in java");
    }

    public void howToDoInJava_method3() {
        System.out.println("how to do");
        if (true) {
            return;
        }else
        {
            return;
        }
       // System.out.println("in java");
    }

    public void howToDoInJava_method4() {
        System.out.println("how to do");
        while (true) {
            return;
        }
        //System.out.println("in java");
    }
}
