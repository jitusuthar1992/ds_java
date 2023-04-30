package main.recusrsion.array;

public class PalindromeCheck {
    boolean checkPalindrome(String str,int i){
        if(i>str.length()-i-1)
            return true;
        if(str.charAt(i)!= str.charAt(str.length()-i-1))
            return false;
        return checkPalindrome(str,i+1);
    }

    boolean checkPalindrome1(String str,int l,int r){
        if(l >= r){
            return true;
        }
        if(str.charAt(l) != str.charAt(r)){
            return false;
        }
        return checkPalindrome1(str,l+1,r-1);
    }


    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(new PalindromeCheck().checkPalindrome1(str,0,4));
    }
}
