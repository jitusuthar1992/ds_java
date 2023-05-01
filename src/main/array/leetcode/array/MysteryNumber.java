package main.array.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class MysteryNumber {
    public static boolean check(int num){

        if(num==0){
            return true;
        }

        Set<Integer> set = new HashSet<>();

        int i = num/2;
        for (int j = 1; i <= num/2; j++) {
            if(!set.contains(j)){
                int rev = getReverse(j);
                if(j +rev == num){
                    System.out.println("Combination are "+j + " and "+rev);
                    return true;
                }
                set.add(j);
                set.add(rev);
            }

        }
        return false;
    }

    private static int getReverse(int num) {
        int rem, rev = 0;
        while (num !=0){
            rem = num%10;
            rev = rev*10 + rem;
            num = num/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(MysteryNumber.check(121));
    }
}
