package main.java1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Note : For every loaded .class file, only one object of Class is created.
public class ClassObject {
    public static void main(String[] args) {
        SwitchWithoutBreak s1 = new SwitchWithoutBreak();
        SwitchWithoutBreak s2 = new SwitchWithoutBreak();
        System.out.println(s1.getClass()==s2.getClass());

    }

}
