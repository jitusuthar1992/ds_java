/*
package main.java1.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructorMetaDataTest {
    public static void main(String[] args) {
        Class c = ConstructorMetaData.class;

        Constructor[] constructors = c.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            // Print all name of each constructor
            System.out.println("Constrcutor name : " + constructor.getName());

            //Get and print access modifiers of each constructor
            System.out.println("Constrctor modifier : " + Modifier.toString(constructor.getModifiers()));

            // Get and print parameter types
            Class[] parameterTypes = constructor.getParameterTypes();

            System.out.print("Constrctor parameter types :");
            for (Class c1 : parameterTypes) {
                System.out.println(c1.getName() + " ");
            }
            System.out.println();

            // Get and print exception thrown by constructors
            Class[] exceptionList = constructor.getExceptionTypes();
            System.out.println("Exception thrown by constructors :");
            for (Class c2 : exceptionList) {
                System.out.println(c2.getName() + " ");
            }
            System.out.println();
            System.out.println("*******************************************");

        }
    }


}
*/
