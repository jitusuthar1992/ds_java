package main.array.codelibrary;

public class CholocateProblem {
    static int findMinDiff(int arr[], int m, int n){
        if(m ==0 || n ==0)
         return 0;

        if(n < m)
            return -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i+m-1 <n ; i++) {
            int diff = arr[i+m-1] - arr[i];
            if(diff < min){
                min = diff;
            }
        }
        return min;
    }
}
