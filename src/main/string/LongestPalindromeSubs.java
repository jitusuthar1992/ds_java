package main.string;

public class LongestPalindromeSubs {
    private static String getLongestpalindromeSubs(String str){
        int n = str.length();
        int start = 0 ,end =1 ;
        int l,h;
        for (int i = 1; i < n ; i++) {

            //even substring
            l = i-1 ;
            h= i;
            while (l >=0 && h < n && str.charAt(l)  == str.charAt(h)){
                if(h-l+1 > end){
                    start = l;
                    end = h-l+1;
                }
                l--;
                h++;
            }
            //odd substring
            l = i-1 ;
            h= i+1;
            while (l >=0 && h < n && str.charAt(l)  == str.charAt(h)){
                if(h-l+1 > end){
                    start = l;
                    end = h-l+1;
                }
                l--;
                h++;
            }
        }
        return str.substring(start,start+end);
    }

    public static void main(String[] args) {
        System.out.println("Longest Palindrome Subs "+LongestPalindromeSubs.getLongestpalindromeSubs("aaaabbaa"));
    }
}
