package main.java1.reflection;

import java.lang.reflect.Modifier;

public class GetclassMetaData {
    public static void main(String[] args) throws ClassNotFoundException {
        //create class object using .class
        Class baseClassObj = BaseClass.class;

        System.out.println("Name of the class is : " + baseClassObj.getName());

        System.out.println("Super Class Name : " + baseClassObj.getSuperclass());

        //get implemented interface list
        Class[] interfaceList =  baseClassObj.getInterfaces();
        System.out.print("Implemented interfaces are : ");
        for(Class c : interfaceList){
            System.out.print(c.getName() + "");
        }
        System.out.println();


        int i = baseClassObj.getModifiers();
        System.out.println("Access modifiers of the class are : " +Modifier.toString(i));

        baseClassObj.isLocalClass();

    }
}
