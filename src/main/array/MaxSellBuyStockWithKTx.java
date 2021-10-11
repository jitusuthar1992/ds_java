package main.array;

public class MaxSellBuyStockWithKTx {
    static int maxProfit(int prices[] , int k){
        int n = prices.length;

        int T[][] = new int[k+1][n];


        for (int i = 0; i <n ; i++) {
            T[0][i] = 0;
        }
        for (int i = 0; i <k+1 ; i++) {
            T[i][0] = 0;
        }

        for (int i = 1; i <k+1 ; i++) {

            for (int j = 1; j <n ; j++) {
                int maxProfit = Integer.MIN_VALUE;
                for (int l = 0; l <j ; l++) {

                    maxProfit = Math.max(maxProfit,prices[j]-prices[l]+T[i-1][l]);
                }
                T[i][j] = Math.max(T[i][j-1],maxProfit);
            }
        }

        return T[k][n-1];
    }

    static int maxProfitSol2(int prices[] , int k){
        int n = prices.length;

        int T[][] = new int[k+1][n];


        for (int i = 0; i <n ; i++) {
            T[0][i] = 0;
        }
        for (int i = 0; i <k+1 ; i++) {
            T[i][0] = 0;
        }

        for (int i = 1; i <k+1 ; i++) {
            int maxProfit = -prices[0];
            for (int j = 1; j <n ; j++) {
                T[i][j] = Math.max(T[i][j-1],maxProfit+prices[j]);
                maxProfit = Math.max(maxProfit,T[i-1][j]-prices[j]);
            }
        }

        return T[k][n-1];
    }

    public static void main(String []args)
    {
        int k = 2;
        int[] price = { 10, 22, 5, 75, 65, 80 };
        int n = price.length;
        System.out.println("Maximum profit is: " +
                maxProfitSol2(price, k));
    }
}
