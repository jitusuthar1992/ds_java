package main.array;

public class SmallestSubArrayWithGreatSum {
    private static int getSmallestSubarrayLength(int arr[] , int x){
        int s =0,mi=0,i=0,j=0;
        int n = arr.length;
        while (i <= j && j <n ){
            while (s <= x && j < n){
                s+= arr[j++];
            }
            while (i<=j && s > x){
                s-= arr[i];
                mi = Math.min(mi,j-i);
                i++;
            }
        }
        return mi;
    }
}
