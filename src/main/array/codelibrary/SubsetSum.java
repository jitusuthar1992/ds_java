package main.array.codelibrary;

import java.util.Arrays;

public class SubsetSum {
    public static int getMaxSumset(int arr[]){
        int n = arr.length;
        int j = n-1;
        Arrays.sort(arr);
        int ans = 0;
        int s1 = 0;
        int s2 =0;
        s1 = Arrays.stream(arr).sum();

        while (true){
            s2+= arr[j];
            s1-= arr[j];
            ans++;
            if(s2 > s1)
                break;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,2};
        System.out.println(SubsetSum.getMaxSumset(arr));
    }
}
