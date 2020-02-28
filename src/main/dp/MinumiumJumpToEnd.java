package main.dp;

import java.util.Arrays;

public class MinumiumJumpToEnd {


    private static int minJumps(int[] arr, int n){

        int minJumps[] = new int[n];
        Arrays.fill(minJumps,Integer.MAX_VALUE);

        minJumps[0] =0;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                if(i <= j+arr[j] ){
                    minJumps[i] =Math.min(minJumps[i],minJumps[j]+1);
                }

            }

        }
        return minJumps[n-1];
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 1, 1, 9,1,4,5,1};
        System.out.println(minJumps(arr,10));
    }
}
