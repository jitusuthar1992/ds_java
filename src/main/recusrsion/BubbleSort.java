package main.recusrsion;

import java.util.stream.IntStream;

public class BubbleSort {
    void sort(int arr[],int n ){
        if(n ==0 || n==1)
            return;
        for (int i = 0; i <n-1 ; i++) {
            if(arr[i] > arr[i+1]){
               int temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
            }
        }
        sort(arr,n-1);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,63,15,14,56,12};
        new BubbleSort().sort(arr,6);
        IntStream.of(arr).forEach(System.out::println);
    }
}