package main.recusrsion;

public class PalindromeCheck {
    boolean checkPalindrome(String str,int i){
        if(i>str.length()-i-1)
            return true;
        if(str.charAt(i)!= str.charAt(str.length()-i-1))
            return false;
        return checkPalindrome(str,i+1);
    }

    public static void main(String[] args) {
        String str = "aba";
        System.out.println(new PalindromeCheck().checkPalindrome(str,0));
    }
}
