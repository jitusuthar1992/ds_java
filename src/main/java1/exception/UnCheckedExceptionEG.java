package main.java1.exception;

/**
 * @author jitendra.kumar01
 * 24/02/20
 */
public class UnCheckedExceptionEG {

    static String name;
    static int count;
    public static void printLength() throws NullPointerException
    {
        System.out.println(name.length());
    }


    //IllegalArgumentException
    public void setCount(int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("cont must not be negative");
        this.count = count;
    }

    public static void main(String[] args) {
        //NumberFormatException
        Integer i = Integer.parseInt("CD");

        //NullPointerException
        printLength();

        //ClassCastException
        String type = "OCAJP8";
        Object obj = type;
        Integer number = (Integer) obj;


        //ArrayIndexOutOfBoundsException
        int[] a = new int[2];
        System.out.println(a[-1]);
    }
}
