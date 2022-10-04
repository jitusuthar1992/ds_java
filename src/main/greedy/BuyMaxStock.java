package main.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class BuyMaxStock {
    static class Stock {
        int unit;
        int price;

        public Stock(int unit, int price) {
            this.unit = unit;
            this.price = price;
        }
    }

    private static int getMaxStock(int stockPrices[], int k){
        Stock[] stocks = new Stock[stockPrices.length];
        for (int i = 0; i <stockPrices.length ; i++) {
            stocks[i] = new Stock(i+1,stockPrices[i]);
        }
        Arrays.sort(stocks, Comparator.comparingInt(s -> s.price));
        int noOfStocks =0;
        for (int i = 0; i <stocks.length ; i++) {
            int unit = stocks[i].unit;
            int price = stocks[i].price;
            if((price*unit) <= k){
                noOfStocks += unit;
                k-= (price*unit);
            }else {
                noOfStocks += (k/price);
                k -= (price * (k/price));
            }
        }
        return noOfStocks;
    }

    public static void main(String[] args) {
        System.out.println(BuyMaxStock.getMaxStock(new int[]{10,7,19},45));
    }
}
