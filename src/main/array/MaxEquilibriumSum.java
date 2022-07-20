package main.array;

import java.util.stream.IntStream;

public class MaxEquilibriumSum {

    static int maxSum(int arr[]) {
        int sum = IntStream.of(arr).sum();
        int prefixSum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                res = Math.max(res, prefixSum);
            }

            sum -= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 5, 3, 1,
                2, 6, -4, 2};
        int n = arr.length;
        System.out.print(maxSum(arr));
    }
}
