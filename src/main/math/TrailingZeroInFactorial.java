package main.math;

public class TrailingZeroInFactorial {
    /*
        1. 2*5 are responsible for every zero
        2. No of 2's are always greater than 5
        3. Trailing zeros = No of 5

        trailingZeros = n/5+n/25+n/125+.....
     */


    public static void findTrailingZeros(int n ){
        int res = 0;

        for (int i = 5; i <=n ; i = i*5) {
            res = res + n/i;
        }
        System.out.println("Trailing Zeros are : "+ res);
    }

    public static void main(String[] args) {
        TrailingZeroInFactorial.findTrailingZeros(12);
        TrailingZeroInFactorial.findTrailingZeros(32);

    }
}
