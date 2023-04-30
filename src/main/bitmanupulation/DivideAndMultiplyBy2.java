package main.bitmanupulation;

public class DivideAndMultiplyBy2 {
    public static void divideNoByTwo(int n){
        int newNo = n >> 1;
        System.out.println("New No after divide by 2 is "+newNo);
    }

    public static void multiplyNoByTwo(int n){
        int newNo = n << 1;
        System.out.println("New No after multiply by 2 is "+newNo);
    }

    public static void main(String[] args) {
        DivideAndMultiplyBy2.divideNoByTwo(15);
        DivideAndMultiplyBy2.multiplyNoByTwo(15);
    }
}
