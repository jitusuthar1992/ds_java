package main.java1;

import java.lang.reflect.Constructor;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.INSTANCE;
        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        Singleton singleton2 = (Singleton) constructor.newInstance();
        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
