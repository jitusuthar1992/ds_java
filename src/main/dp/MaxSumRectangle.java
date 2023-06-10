package main.dp;

import main.array.MaxSumArraySum;

import java.util.Arrays;

public class MaxSumRectangle {
    public static int maxSum(int matrix[][]){
        int row = matrix.length;
        int col = matrix.length;
        int ans = Integer.MIN_VALUE;
        int sum[] = new int[row];
        for (int cStart = 0; cStart <col ; cStart++) {
            Arrays.fill(sum,0);
            for (int cEnd = cStart; cEnd <col ; cEnd++) {
                for (int r = 0; r < row; r++) {
                    sum[r]+= matrix[row][cEnd];
                }
                int currMax = MaxSumArraySum.maxSubArraySum(sum,sum.length);
                ans = Math.max(ans,currMax);
            }
        }
        return ans;
    }
}