package main.java1;

/**
 * @author jitendra.kumar01
 * 19/02/20
 */
public class LimitInstanceClass {
    private static LimitInstanceClass limInstance;
    public static int objCount = 0;

    private LimitInstanceClass() {
        objCount++;
    }

    public static synchronized LimitInstanceClass getLimInstance() {
        if (objCount < 3) {
            limInstance = new LimitInstanceClass();
        }
        return limInstance;
    }

    public static void main(String[] args) {
        LimitInstanceClass obj1 = LimitInstanceClass.getLimInstance();
        LimitInstanceClass obj2 = LimitInstanceClass.getLimInstance();
        LimitInstanceClass obj3 = LimitInstanceClass.getLimInstance();
        LimitInstanceClass obj4 = LimitInstanceClass.getLimInstance();
        LimitInstanceClass obj5 = LimitInstanceClass.getLimInstance();
        LimitInstanceClass obj6 = LimitInstanceClass.getLimInstance();

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
        System.out.println(obj5.hashCode());
        System.out.println(obj6.hashCode());
    }
}
