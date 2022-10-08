package main.array;

public class MaxProfit2Tx {
    private static int getMaxProfit(int prices[]){
        int n = prices.length;
        int mi = prices[n-1];
        int ma = prices[0];
        int dp[] = new int[n];
        for (int i = 0; i < n ; i++) {
            dp[i] =0 ;
        }

        for (int i = n-2; i >=0 ; i--) {
            if(prices[i] > ma )
                ma = prices[i];
            dp[i] = Math.max(dp[i+1],ma-prices[i]);
            
        }
        for (int i = 1; i < n ; i++) {
            if(prices[i] < mi )
                mi = prices[i];
            dp[i] = Math.max(dp[i-1],dp[i]+ (prices[i]-mi));
        }
        return dp[n-1];
    }
}
