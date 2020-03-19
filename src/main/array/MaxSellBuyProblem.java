package main.array;

public class MaxSellBuyProblem {

    public static int maxProfit(int arr[]){
        int n = arr.length;

        int currentBuy = arr[0] ,currentSell = arr[0], maxProfit =0;


        for (int i = 1; i <n ; i++) {
            if(arr[i] < currentBuy){
                currentBuy = arr[i];
                currentSell = arr[i+1];

                if(currentSell-currentBuy > maxProfit){
                    maxProfit = currentSell-currentBuy;
                }
            }else if(arr[i] > currentSell){
                currentSell = arr[i];
                if(currentSell-currentBuy > maxProfit){
                    maxProfit = currentSell-currentBuy;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = {2,11,1,4,7};
        System.out.printf("Max profit = "+maxProfit(arr));
    }

}
