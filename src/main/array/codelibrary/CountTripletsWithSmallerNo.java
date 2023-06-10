package main.array.codelibrary;

import java.util.Arrays;

public class CountTripletsWithSmallerNo {
    static int countTriplets(int arr[], int sum) {
        int n = arr.length;
        Arrays.sort(arr);
        int c =0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {


                if (x + arr[l] +
                        arr[r] < sum){
                    l++;
                    c+= (r-l);
                }



                    // if sum is greater than
                    // given sum, then decrement
                    // in right side
                else
                    r--;
            }
        }
        return c;

    }
}
