package main.java1.inheritance;

public class Inheritance {
    public static void main(String[] args) {
        A obj = new C();
        obj.test();
    }
}
class A {

    protected void test() throws ArithmeticException{
        System.out.println("Class A");
    }
}
class B extends A {

    @Override
    protected void test(){
        System.out.println("Class A");
    }
}
class C extends B{

    @Override
    public void test(){
        System.out.println("Class C");
    }
}
