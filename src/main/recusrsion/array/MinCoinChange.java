package main.recusrsion.array;

public class MinCoinChange {

    public static void main(String[] args) {
        int total = 18;
        int coins[] = {7, 5,1};
        System.out.println(MinCoinChange.minCoins(18,coins));
    }
    static int minCoins(int n , int coins[]){
        if(n==0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <coins.length ; i++) {
            if(n-coins[i] >=0){
                int subAns = minCoins(n-coins[i],coins);
                if(subAns+1 < ans && subAns != Integer.MAX_VALUE){
                    ans = subAns +1;
                }
            }
        }
        return ans;
    }
}
