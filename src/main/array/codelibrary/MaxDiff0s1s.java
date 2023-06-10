package main.array.codelibrary;

public class MaxDiff0s1s {
    public static int maxDiff(char[] s){
        int max_untill = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length; i++) {
            int x = s[i] == 0 ? 1: -1;
            max_untill += x;
            ans = Math.max(ans,max_untill);
            if(max_untill < 0){
                max_untill = 0;
            }
        }
        return ans;
    }
}
