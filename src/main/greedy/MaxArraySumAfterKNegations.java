package main.greedy;

import java.util.Arrays;

public class MaxArraySumAfterKNegations {
    private  static int getMaxSum(int[] arr ,int k ){
        Arrays.sort(arr);
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] < 0 && k > 0){
                arr[i] = -arr[i];
                k--;
            }
        }
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int min = Arrays.stream(arr).min().getAsInt();
        if(k %2 != 0){
            sum -= min*2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Max Sum : "+ MaxArraySumAfterKNegations.getMaxSum(new int[]{1,2,-3,4,5},1));
    }
}
