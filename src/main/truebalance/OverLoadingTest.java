package main.truebalance;

/**
 * @author jitendra.kumar01
 * 07/02/20
 */
public class OverLoadingTest {
    public int sum(int x, int y)
    {
        return (x + y);
    }

    // Overloaded sum(). This sum takes three int parameters
    public int sum(int x, int y, int z)
    {
        return (x + y + z);
    }

    // Overloaded sum(). This sum takes two double parameters
    public double sum(double x, double y)
    {
        return (x + y);
    }



    /**
     *Q. What if the exact prototype does not match with arguments.
     *
     * Priority wise, compiler take these steps:
     * 1.Type Conversion but to higher type(in terms of range) in same family.
     * 2.Type conversion to next higher family(suppose if there is no long data
     * type available for an int data type, then it will search for the float data type).
     */

    public void show(int x)
    {
        System.out.println("In int " + x);
    }
    public void show(String s)
    {
        System.out.println("In String " + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte " + b);
    }


     //We cannot overload by return type

    //  public int foo(int a) { return 10; }

    //  public char foo(int a) { return 'a'; }


    // overloading in static methods
    public static int foo(int a) { return 10; }
    public static char foo(int a, int b) { return 'a'; }

    /**
     * Can we overload methods that differ only by static keyword?
     * We cannot overload two methods in Java if they differ only by
     * static keyword (number of parameters and types of parameters is same).
     * See following Java program for example. Refer this for details.
     *
     */


    // Driver code
    public static void main(String args[])
    {
        OverLoadingTest s = new OverLoadingTest();
        System.out.println(s.sum(10, 20));
        System.out.println(s.sum(10, 20, 30));
        System.out.println(s.sum(10.5, 20.5));

        s.show( 25); // it will go to
        // byte argument
        s.show("hello"); // String
        s.show(250); // Int
        s.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        s.show("A"); // String

        //s.show(7.5); // since float datatype
        // is not available and so it's higher
        // datatype, so at this step their
        // will be an error.
    }
    // Overloaded main methods
    public static void main(String arg1)
    {
        System.out.println("Hi, " + arg1);
        OverLoadingTest.main("Dear Geek", "My Geek");
    }
    public static void main(String arg1, String arg2)
    {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}
