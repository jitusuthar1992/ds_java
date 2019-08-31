package main.string;

import java.util.Arrays;

public class PalindromeConvertable {
    static boolean canFormPalindrome(String str) {
        int count[] = new int[26];
        Arrays.fill(count,0);
        for (int i = 0; i <str.length() ; i++) {
            //System.out.println((int)str.charAt(i));
            count[(str.charAt(i)-96)]++;
        }


        int oddCount=0;
        for (int i = 0; i <count.length ; i++) {
            if(count[i] >0){
                System.out.println((char)(i+96) +"::" +count[i]);
                if(count[i] %2 ==1)
                    oddCount++;
                if(oddCount >1)
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("geeksforgeeksa"));

    }
}
