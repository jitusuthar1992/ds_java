package main.array.codelibrary;

public class MoveNegativeElements {
    public static void move(int[] arr, int n){
        int i=-1,pivot=0;
        for (int j = 0; j <n ; j++) {
            if(arr[j] < pivot){
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j]= t;
            }
        }
        for (int j = 0; j <n ; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,-2,9,0,-1,-3,7,-2};
        MoveNegativeElements.move(arr,arr.length);
    }
}
