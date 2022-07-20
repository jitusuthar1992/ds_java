package main.truebalance;

/**
 * @author jitendra.kumar01
 * 07/02/20
 */
public class MainMethodVariants {

    public strictfp synchronized static final void main(final String[] args) { // declaring main () method with final keyword.
        BaseClass b = new BaseClass();
        DerivedClass d = new DerivedClass();
        b.show(new Integer(0));
        d.show(new Integer(0));
    }

    //Overloading Main method
    public static void main(int[] args) {
        System.out.println("Main Method int Array");
    }
}


class BaseClass {
    public static void show(Object o) {
        System.out.println("BaseClass method");
    }
}

class DerivedClass extends BaseClass {
    public void show(Integer i) {
        System.out.println("DerivedClass method");
    }
}
