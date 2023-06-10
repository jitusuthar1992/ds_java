package main.array.codelibrary;

public class ThreeWayPartition {
    public void partition(int arr[], int a , int b){
        int l =0;
        int r = arr.length-1;

        for (int i = 0; i <=r ; i++) {
            if(arr[i]<a){
                int t = arr[i];
                arr[i] = arr[l];
                arr[l] = t;
                l++;
            } else if (arr[i]> b) {
                int t = arr[i];
                arr[i] = arr[r];
                arr[r] = t;
                r--;
                i--;
            }
        }
    }
}
