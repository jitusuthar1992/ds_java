package main.bitmanupulation;

public class Swap2Nos {
    public static void swap(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a after swap "+a);
        System.out.println("b after swap "+b);
    }

    public static void main(String[] args) {
        Swap2Nos.swap(3,5);
    }
}
