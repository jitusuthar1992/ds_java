package main.java1;

public class EnumDemo {
    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.hashCode());
        singleton.setValue(2);
        System.out.println(singleton.hashCode());
    }
}
