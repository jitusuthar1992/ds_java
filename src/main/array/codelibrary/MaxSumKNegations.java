package main.array.codelibrary;

import java.util.Arrays;

public class MaxSumKNegations {

    public static int maxSum(int arr[], int k){

        int sum = 0;

        Arrays.sort(arr);
        for (int i = 0; i <arr.length ; i++) {

            if(arr[i] < 0 && k > 0){
                arr[i] = - arr[i];
                k--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        int min =  getMinValue(arr);
        if((k&1) ==0)
            sum -= 2*min;
        return sum;
    }

    public static int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }

}
