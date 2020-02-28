package main.sorting;

/**
 * @author jitendra.kumar01
 * 08/02/20
 */
public class SelectionSort {

    void sort(int arr[], int n){
        for (int i = 0; i <n ; i++) {
            int minIndex = i;
            for (int j = i+1; j <n ; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6 };
        InsertionSort ob = new InsertionSort();
        ob.sort(arr,arr.length);

        printArray(arr);
    }
}
