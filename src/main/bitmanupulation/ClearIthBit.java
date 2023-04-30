package main.bitmanupulation;

public class ClearIthBit {
    public  static void clearIthBit (int no , int bit){
        int mask = ~(1 << bit);
        int newNum = no & mask;
        System.out.println("New No after ithBit clear is "+newNum);
    }

    public static void main(String[] args) {
        ClearIthBit.clearIthBit(309,4);
    }
}
