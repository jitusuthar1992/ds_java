package truebalance;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Test {

    static  int a =3;
    static int b ;

    static void method(int x){
        System.out.println("x = "+x);
        System.out.println("a = "+a);
        System.out.println("b = "+b);

    }

    static {
        System.out.println("a ="+a);
        b=a*4;
    }

    /*public static void main(String[] args) {
        method(55);
    }*/



    void display(Object o){
        System.out.println("Object");
    }
    void display(String s){
        System.out.println("String");
    }

    public static void main(String[] args) {
        new Test().display(null);
    }
    /*public static void main(String[] args) {

        boolean t = true;
        System.out.println("Hello");

        if(t)
            return;
        System.out.println("Bye");
    }*/

    /*public static void main(String[] args) {
        List<Integer>   ts = new ArrayList<>();

        ts.add(100);
        ts.add(1);

        ts.add(1000);
        ts.add(10);
        ts.add(10000);
        ts.add(10);

        NavigableSet<Integer> N = new TreeSet<>(ts);
        System.out.println(N.tailSet(10,false));
        System.out.println(N.tailSet(10));
        System.out.println(N.higher(10));

        int A= N.pollFirst();

        System.out.println(N.size());





    }*/
}
