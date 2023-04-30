package main.bitmanupulation;

public class EvenOddNumber {
    public static void evenOrOdd(int n){
        if((n & 1) ==0){
            System.out.println(n +" is even");
        }else {
            System.out.println(n+ " is odd");
        }
    }

    public static void main(String[] args) {
        EvenOddNumber.evenOrOdd(16);
        EvenOddNumber.evenOrOdd(5);
    }
}
