package main.dp;

public class StairCaseProblem {
    public static void main(String args[])
    {
        int arr[] = { 1, 3, 4 };

        int n = 4;

        System.out.println(noOfWays(n ,arr));
    }

    public static int noOfWays(int n ,int[] steps ){

        int c = n+1;
        int r = steps.length+1;
        int arr[][] = new int[r][c];

        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(i == 0 || j==0){
                    arr[i][j]=0;
                }else if( j < steps[i-1]){
                    arr[i][j] = arr[i-1][j];
                }else {
                    arr[i][j] = steps[i-1]+arr[i-1][j-steps[i-1]];
                }
            }
        }
        return arr[r-1][c-1];
    }

    static int countWays(int n, int arr[], int len){
        int count[] = new int[n + 1];
        count[0] = 1;

        // Base case
        if (n == 0)
            return 1;

        // For every stair
        for (int i = 1; i <= n; i++) {

            // To store the count of ways
            // till the current stair
            int no_ways = 0;

            // Every step from the array
            for (int j = 0; j < len; j++) {

                // Here consider only
                // the values of "i - arr[j]" >= 0
                // because negative values
                // indicates reverse climbing
                // of steps
                if (i - arr[j] >= 0) {
                    no_ways += count[i - arr[j]];
                }
                count[i] = no_ways;
            }
        }

        return count[n];
    }
}
