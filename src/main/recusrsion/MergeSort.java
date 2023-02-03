package main.recusrsion;

import java.util.stream.IntStream;

public class MergeSort {

    void mergeSort(int arr[],int s,int e){
        if(s >= e)
            return;
        int mid = (s+e)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,e);
    }

    private void merge(int[] arr, int s, int e) {
        int mid = (s+e)/2;
        int len1 = mid-s +1;
        int len2 = e-mid;
        int left[] = new int[len1];
        int right[] = new int[len2];

        int k =s;
        for (int i = 0; i <len1 ; i++) {
            left[i]= arr[k++];
        }

        k =mid+1;
        for (int i = 0; i <len2 ; i++) {
            right[i]= arr[k++];
        }

        int index1 =0 ,index2 =0 ,mainIndex = s;

        while (index1 < len1 && index2 < len2){
            if(left[index1] < right[index2]){
                arr[mainIndex++] = left[index1++];
            }else {
                arr[mainIndex++] = right[index2++];
            }
        }
        while (index1 < len1 ){
            arr[mainIndex++] = left[index1++];
        }
        while (index2 < len2 ){
            arr[mainIndex++] = right[index2++];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,63,15,14,56,12};
        new MergeSort().mergeSort(arr,0, arr.length-1);
        IntStream.of(arr).forEach(System.out::println);
    }
}
