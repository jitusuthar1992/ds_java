package main.array;

public class MaxProfitStock {
    private static int getMaxProfit(int prices[]){
        int curr_price = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < curr_price){
                curr_price = prices[i];
            } else if (prices[i] - curr_price > profit) {
                profit = prices[i] - curr_price;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.printf("Max profit = " + MaxProfitStock.getMaxProfit(arr));
    }
}
