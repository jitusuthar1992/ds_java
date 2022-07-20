package main.java1;


class Outer {
    void outerMethod() {
        int x = 98;
        System.out.println("inside outerMethod");
        class Inner {
            void innerMethod() {
                System.out.println("x= " + x);
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}

public class MethodLocalVariableDemo {
    public static void main(String[] args) {
        Outer x = new Outer();
        x.outerMethod();
    }
}
