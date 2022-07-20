package main.dp;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "abcdef";
        String s2 = "zcdemf";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(X, Y, m, n));
    }

    private int lcs(char[] x, char[] y, int m, int n) {

        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }

        }
        return L[m][n];
    }

    /*private int lcs1(char[] x, char[] y, int m, int n) {

        int L[][] = new int[m+1][n+1];


        int max = Integer.MIN_VALUE;
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {

                if(x[i-1] == y[j-1]){
                    L[i][j]  =  L[i-1][j-1] + 1;
                    if(L[i][j] > max){
                        max = L[i][j];
                    }
                }
            }

        }
        return max;
    }
*/
}

