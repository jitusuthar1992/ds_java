package main.array;

public class MaxProfit2Trax {
    static int maxProfit1(int arr[]){
        int profit = 0,n=arr.length;
        int leftMax[] = new int[n] , rightMax[] = new int[n];
        int leftMin = arr[0], rightMx= arr[n-1];
        leftMax[0] = 0;
        rightMax[n-1] =0;
        for (int i = 1; i <n ; i++) {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]-leftMin);
            leftMin = Math.min(leftMin,arr[i]);
        }

        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1],rightMx - arr[i]);
            rightMx = Math.max(rightMx,arr[i]);
        }

        for (int i = 1; i < n ; i++) {
            profit = Math.max(profit,leftMax[i-1]+rightMax[i]);
        }
        return profit;

    }
    public static void main(String[] args) {
        int[] price = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};

        System.out.print("\nTotal profit earned is " + maxProfit1(price));
    }
}
