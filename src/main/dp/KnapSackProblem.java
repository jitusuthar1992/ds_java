package main.dp;

public class KnapSackProblem {
    static int knapsack(int W, int wt[], int val[], int n) {
        int sol[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    sol[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    sol[i][j] = Math.max(sol[i - 1][j], val[i - 1] + sol[i - 1][j - wt[i - 1]]);
                } else {
                    sol[i][j] = sol[i - 1][j];
                }
            }
        }
        return sol[n][W];
    }

    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }
}
