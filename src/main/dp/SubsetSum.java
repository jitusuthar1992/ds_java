package main.dp;

public class SubsetSum {

    public static boolean isSubsetSum(int[] set, int sum) {
        boolean subsetSum[][] = new boolean[set.length + 1][sum + 1];

        subsetSum[0][0] = true;

        for (int i = 1; i < sum + 1; i++) {
            subsetSum[0][i] = false;
        }
        for (int i = 1; i < set.length + 1; i++) {
            subsetSum[i][0] = true;
        }

        for (int i = 1; i < set.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - set[i - 1] < 0) {
                    subsetSum[i][j] = subsetSum[i - 1][j];
                } else {
                    subsetSum[i][j] = subsetSum[i - 1][j] || subsetSum[i - 1][j - set[i - 1]];
                }
            }
        }


        for (int i = 0; i < set.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(subsetSum[i][j] + " ");
            }
            System.out.println();

        }
        return subsetSum[set.length][sum];
    }

    public static void main(String[] args) {
        int set[] = {1, 2, 5, 7};
        int sum = 4;

        if (SubsetSum.isSubsetSum(set, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");


    }
}
