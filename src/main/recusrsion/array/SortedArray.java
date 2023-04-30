package main.recusrsion.array;

import java.util.Arrays;

public class SortedArray {

    public static boolean isSorted(int arr[], int size){
        if(size ==0 || size ==1)
            return true;
        if(arr[0] > arr[1])
            return false;
        int arrNew[] = Arrays.copyOfRange(arr,1,arr.length);
        return isSorted(arrNew,size-1);
    }

    public static void main(String[] args) {
        int arr[] = {1,4,3,40};
        System.out.println("Is Sorted :"+SortedArray.isSorted(arr,4));
    }
}
