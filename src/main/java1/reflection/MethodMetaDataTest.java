/*
package main.java1.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodMetaDataTest {
    public static void main(String[] args) {
        MethodMetaData obj = new MethodMetaData();
        Class c = obj.getClass();

        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method Name : " + method.getName());
            System.out.println("Method Return Type : " + method.getReturnType());
            System.out.println("Method Modifiers : " + Modifier.toString((method.getModifiers())));

            Class[] parameterTypes = method.getParameterTypes();

            System.out.print("Method parameter types : ");

            for (Class paramType : parameterTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();

            Class[] exceptionTypes = method.getExceptionTypes();
            System.out.print("Exception Types : ");
            for (Class exceptionType : exceptionTypes) {
                System.out.print(exceptionType.getName() + " ");
            }
            System.out.println();

            System.out.println();
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");


        }
    }
}
*/
