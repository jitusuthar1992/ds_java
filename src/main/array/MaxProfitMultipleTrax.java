package main.array;

public class MaxProfitMultipleTrax {

    static int maxProfit(int arr[]) {
        int profit = 0;
        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                j = i;
            }


            if (arr[i - 1] <= arr[i] && (i + 1 == arr.length || arr[i] > arr[i + 1])) {
                profit += (arr[i] - arr[j]);
                System.out.println("Buy on day " + (j + 1) + " and sell on day " + (i + 1));
            }
        }

        return profit;
    }


    public static void main(String[] args) {
        int[] price = {5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0};

        System.out.print("\nTotal profit earned is " + maxProfit(price));
    }
}
