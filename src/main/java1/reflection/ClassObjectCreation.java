package main.java1.reflection;

public class ClassObjectCreation {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1 By using Class.forName()
        Class c1 = Class.forName("ClassObjectCreation");

        //2 By Using getClass()

        ClassObjectCreation obj = new ClassObjectCreation();
        Class c2 = obj.getClass();

        //3 By using .class
        Class c3 = ClassObjectCreation.class;

    }

}
