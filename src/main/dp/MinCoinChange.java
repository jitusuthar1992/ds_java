package main.dp;

import java.util.Arrays;

public class MinCoinChange {
    public static void main(String[] args) {
        int total = 18;
        int coins[] = {7, 5,1};
        int dp[] = new int[total+1];
        Arrays.fill(dp,-1);
        dp[0] =0;

        System.out.println(MinCoinChange.minCoins(18,coins,dp));
    }
    static int minCoins(int n , int coins[],int dp[]){
        if(n==0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <coins.length ; i++) {
            if(n-coins[i] >=0){
                int subAns;
                if(dp[n-coins[i]] != -1) {
                    subAns= dp[n-coins[i]];
                }else {
                    subAns = minCoins(n - coins[i], coins,dp);
                }
                if(subAns+1 < ans && subAns != Integer.MAX_VALUE){
                    ans = subAns +1;
                }
            }
        }
        return dp[n] = ans;
    }
}
