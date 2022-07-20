package main.java1.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jitendra.kumar01
 * 21/02/20
 */
public class ImmutableClassWithList {
    private int var1;

    private final List<String> strings;
    //private final List<String> strings = new ArrayList<String>();

    public ImmutableClassWithList(int var, final List<String> stringList) {
        this.var1 = var;
        /*List<String> stringList1 = new ArrayList();
        stringList1.addAll(stringList);*/
        this.strings = stringList;
       /* strings.add("string 1");
        strings.add("string 2");*/
    }

    public List<String> getStrings() {
        List<String> newStrings = new ArrayList<String>();
        newStrings.addAll(strings);
        return newStrings;
    }

    public int getVar1() {
        return var1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = Arrays.asList("Test1", "test2");
        ImmutableClassWithList im = new ImmutableClassWithList(10, list);
        System.out.println(im.getStrings());
        im.getStrings().remove("string 2");
        System.out.println(im.getStrings());

    }
}
