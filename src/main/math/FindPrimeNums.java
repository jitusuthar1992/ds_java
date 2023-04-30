package main.math;

import java.util.Arrays;

public class FindPrimeNums {
    public static boolean[] seiveOfEratosthenes(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <=n ; i++) {
            for (int j = 2*i; j <=n ; j+=i) {
                isPrime[j]= false;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        boolean isPrime[] = FindPrimeNums.seiveOfEratosthenes(20);
        for (int i = 1; i <=20 ; i++) {
            System.out.println(i+ " is prime : "+isPrime[i]);
        }
    }
}
