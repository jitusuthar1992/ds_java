package main.recusrsion;

import java.util.Arrays;

public class ArraySum {
    static int getSum(int arr[], int size){
        if(size ==0)
            return 0;
        if(size ==1)
            return arr[0];
        int arr_new[] = Arrays.copyOfRange(arr,1,arr.length);
        int remainingSum = getSum(arr_new,size-1);
        int sum = arr[0]+remainingSum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(ArraySum.getSum(new int[]{1,2,3,4},4));
    }
}
