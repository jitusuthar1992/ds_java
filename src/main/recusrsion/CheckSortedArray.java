package main.recusrsion;

import java.util.Arrays;

public class CheckSortedArray {
    static boolean isSorted(int arr[], int size){
        if(size ==0 || size ==1){
            return true;
        }
        if(arr[0]>arr[1]){
            return false;
        }else {
            int arr_new[] = Arrays.copyOfRange(arr,1,arr.length);
            return isSorted(arr_new,size-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Sorted Array :"+isSorted(new int[]{1,3,4,6,6,7},6));
    }

}
