package main.dp;

import java.util.Arrays;

public class CoinChangeProblem {


    static int countSol2(int a[], int n, int m) {
        int dp[][] = new int[m][n+1];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n+1 ; j++) {
                dp[i][j] =-1;
            }
        }
        return solve(a,dp,m-1,n);
    }

    static int countSol3(int a[], int n, int m) {
        int[] table = new int[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < m; i++)
            for (int j = a[i]; j <= n; j++)
                table[j] += table[j - a[i]];

        return table[n];
    }

    private static int solve(int[] a, int[][] dp, int m, int n) {
        if(m ==-1 && n >0)
            return 0;
        if(n==0)
            return 1;
        if(n < 0)
            return 0;
        if(dp[m][n] !=-1)
            return dp[m][n];
        return dp[m][n] = solve(a,dp,m,n-a[m])+solve(a,dp,m-1,n);
    }

    static int countSol1(int a[], int n, int m) {
        int table[][] = new int[m + 1][n + 1];
        table[0][0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (i > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - i];
                }
            }


        }
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println(table);
        return table[m][n];
    }


    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println(countSol3(a, 4, 3));

    }
}
