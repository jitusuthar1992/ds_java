package main.java1;

/**
 * @author jitendra.kumar01
 * 12/12/19
 */
public class AbstractClassTest extends Test {
    public static void method1() {
        System.out.println("Child method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");

    }
    //public abstract void method2();

    public static void main(String[] args) {
        Test test = new AbstractClassTest();
        test.method1();
        AbstractClassTest obj = new AbstractClassTest();
        obj.method1();

        Test.method1();

    }
}


abstract class Test {
    public static void method1() {
        System.out.println("Parent method1");
    }

    public abstract void method2();
}

