package main.java1;

public class StaticMethodInterface implements IStaticMethodInterface {
    public static void main(String[] args) {
        IStaticMethodInterface.show();
    }
}


interface IStaticMethodInterface {
    static void show() {
        System.out.println("Calling show");
    }
}



