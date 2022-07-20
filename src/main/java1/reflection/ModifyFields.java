package main.java1.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ModifyFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Test.class.getDeclaredField("check");
        field.setAccessible(true);
        //field.set(null,true);

        int modifiers = field.getModifiers();
        Field modifierField = field.getClass().getDeclaredField("modifiers");
        modifiers = modifiers & ~Modifier.FINAL;
        modifierField.setAccessible(true);
        modifierField.setInt(field, modifiers);

        field.set(field, true);

        System.out.println(Test.getCheck());
    }

}


class Test {
    private static final Boolean check = false;

    public Test() {
    }

    public static Boolean getCheck() {
        return check;
    }
}