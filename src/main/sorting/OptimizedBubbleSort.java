package main.sorting;

public class OptimizedBubbleSort {
    public static void  sort(int arr[], int n){
        if(n == 0)
            return;
        int temp;
        boolean swap;
        for (int i = 0; i <n-1 ; i++) {
            swap = false;

            for (int j = 0; j <n-i-1 ; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap =true;
                }
            }
            if(!swap )
                break;
        }
    }
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        sort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
