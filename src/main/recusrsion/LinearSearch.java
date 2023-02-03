package main.recusrsion;

import java.util.Arrays;

public class LinearSearch {
    static boolean isElementExist(int arr[], int size , int key){
        if(size ==0)
            return false;
        if(arr[0] == key)
            return true;
        else {
            int arr_new[] = Arrays.copyOfRange(arr,1,arr.length);
            return isElementExist(arr_new,size-1,key);
        }
    }

    public static void main(String[] args) {
        System.out.println(LinearSearch.isElementExist(new int[]{1,2,3,4},4,5));

    }
}
