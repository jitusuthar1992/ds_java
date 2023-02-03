package main.recusrsion;

import java.util.stream.IntStream;

public class QuickSort {
    void quickSort(int[] arr , int s , int e){
        if(s>= e)
            return;
        int pivotIndex = partition(arr,s,e);
        quickSort(arr,s,pivotIndex-1);
        quickSort(arr,pivotIndex+1,e);
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[s];

        int cnt =0;
        for (int i = s+1; i <=e ; i++) {
            if(arr[i] <= pivot)
                cnt++;
        }

        int pivotIndex = s+cnt;
        int temp = arr[s];
        arr[s] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i =s , j= e;
        while (i < pivotIndex && j> pivotIndex){
            while (arr[i] < pivot){
                i++;
            }
            while (arr[j] > pivot){
                j--;
            }
            if(i < pivotIndex && j > pivotIndex){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return pivotIndex;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,63,15,14,56,12};
        new QuickSort().quickSort(arr,0,5);
        IntStream.of(arr).forEach(System.out::println);
    }
}
