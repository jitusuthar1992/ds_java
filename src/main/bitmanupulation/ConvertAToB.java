package main.bitmanupulation;

public class ConvertAToB {
    public static void  noOfBitsChange(int a , int b){

        int newNum = a ^ b;
        int bits = 0;
        while (newNum > 0){

            if((newNum & 1) == 1){
                bits++;
            }
            newNum = newNum >> 1;
        }

        System.out.println("No of bits changed is "+bits);
    }

    public static void main(String[] args) {
        ConvertAToB.noOfBitsChange(22,27 );
    }
}
