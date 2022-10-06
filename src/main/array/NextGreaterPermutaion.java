package main.array;

public class NextGreaterPermutaion {
    private static void nextPermutation(int arr[]){
        int idx = -1;
        for (int i = arr.length-1 ; i > 0 ; i--) {
            if(arr[i] > arr[i-1]){
                idx =i;
                break;
            }
        }
        if(idx == -1){
            //reverseArray
        }else {
            int prev = idx;
            for (int i = idx+1; i < arr.length ; i++) {
                if(arr[i] > arr[idx-1] && arr[i] <= arr[prev]){
                    prev = i;
                }
            }
            int temp = arr[idx-1];
            arr[idx-1] = arr[prev];
            arr[prev] = temp;
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
