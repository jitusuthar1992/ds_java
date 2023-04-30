package main.bitmanupulation;

public class SetIthBit {
    public static void setIthBit(int no , int ithBit){
        int mask = 1 << ithBit;
        int n = no | mask;

        System.out.println("New No after ithBit set to 1 is "+n);
    }

    public static void main(String[] args) {
        //Old no 309 , new no 317
        SetIthBit.setIthBit(309,3);
    }
}
