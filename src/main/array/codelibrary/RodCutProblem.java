package main.array.codelibrary;

public class RodCutProblem {
    public static int getMaxProfit(int prices[], int n){
        int value[] = new int[n+1];
        value[0] = 0;
        for (int i = 1; i <= n  ; i++) {
            for (int j = 0; j <i ; j++) {
                value[i] = Math.max(value[i],prices[j]+value[i-j-1]);
            }
        }
        return value[n];
    }

}
