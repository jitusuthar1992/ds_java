package main.array.hackerrank;

import java.util.List;

public class DiagonalSumDifference {
    public static int diagonalDifference(int [][]arr , int n) {
        int sumleft =0,sumright = 0;
        for (int i = 0; i <n ; i++) {
            sumleft += arr[i][i];
            sumright += arr[i][n-i-1];

        }
        return Math.abs(sumleft-sumright);
    }

    public static void main(String[] args)
    {
        int n = 3;

        int arr[][] =
                {
                        {11, 2, 4},
                        {4 , 5, 6},
                        {10, 8, -12}
                };

        System.out.print(diagonalDifference(arr, n));

    }
}
