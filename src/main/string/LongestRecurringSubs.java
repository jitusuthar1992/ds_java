package main.string;

public class    LongestRecurringSubs {
    private static int getLongestRecurCount(String s){
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==0 || j==0)
                    dp[i][j]= 0;
                else if (s.charAt(i-1)==s.charAt(j-1) && i != j) {
                    dp[i][j] =  dp[i-1][j-1] +1;
                }else {
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
