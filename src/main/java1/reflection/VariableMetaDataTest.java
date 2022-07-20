package main.java1.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class VariableMetaDataTest {
    public static void main(String[] args) throws IllegalAccessException {
        VariableMetaData obj = new VariableMetaData();
        Class c = obj.getClass();

        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("Variable Name : " + field.getName());
            System.out.println("Variable Type : " + field.getType());

            int i = field.getModifiers();

            System.out.println("Access Modifier for variable : " + Modifier.toString(i));

            System.out.println("value of field :" + field.get(field));

            System.out.println();
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        }
    }
}
