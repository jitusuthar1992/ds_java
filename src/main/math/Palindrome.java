package main.math;

public class Palindrome {
    public static void checkPalindrome(int num){
        int res = 0;
        while (num > 0){
            int mod = num %10;
            res = (res*10) + mod;
            num = num/10;
        }
        System.out.println("Reverse no "+ res);

    }

    public static void main(String[] args) {
        Palindrome.checkPalindrome(125);
    }
}
