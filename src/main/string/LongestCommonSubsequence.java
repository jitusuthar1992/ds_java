package main.string;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int maxSubsequenceSubstring(String X,String Y,int n,int m,int dp[][])
    {
        // Base Case
        if (n==0 || m==0) return 0;

        // check if we have already solved it?
        if(dp[n][m] != -1) return dp[n][m];


        // Calls on smaller inputs

        // if the last char of both strings are equal
        if(X.charAt(n-1) == Y.charAt(m-1))
        {
            return dp[n][m] = 1 + maxSubsequenceSubstring(X,Y,n-1,m-1,dp);
        }

        // if the last char of both strings are not equal
        else
        {
            return dp[n][m] = maxSubsequenceSubstring(X,Y,n-1,m,dp);
        }
    }
    public static void main(String args[])
    {
        String X = "abcd";
        String Y = "bacdbdcd";
        int n = X.length(),m = Y.length();
        int maximum_length = 0; //as minimum length can be 0 only.

        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0;i<=m;i++) // traversing for every length of Y.
        {
            int temp_ans = maxSubsequenceSubstring(X,Y,n,i,dp);
            if(temp_ans > maximum_length) maximum_length = temp_ans;
        }
        System.out.println("Length for maximum possible Subsequence of string X which is Substring of Y -> "+maximum_length);
    }
}
