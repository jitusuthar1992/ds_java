package main.recusrsion.array;

public class StairCasePb {

    public static void main(String args[])
    {
        int arr[] = { 1, 3, 5 };
        int len = arr.length;
        ;
        int n = 5;

        System.out.println(countWays(n, arr, len));

        System.out.println(noOfWays(n ,arr));
    }
    static int countWays(int n, int arr[], int len){
        if(n ==0){
            return 1;
        }
        int noWays =0;
        for (int i = 0; i <len ; i++) {
            if(n-arr[i] >= 0){
                noWays+= countWays(n-arr[i],arr,len);
            }
        }
        return noWays;
    }

    public static int noOfWays(int n ,int[] steps ){

        int r = n+1;
        int c = steps.length+1;
        int arr[][] = new int[c][r];

        for (int i = 0; i <c ; i++) {
            for (int j = 0; j <r ; j++) {
                if(i == 0 || j==0){
                    arr[i][j]=0;
                }else if( j < steps[i-1]){
                    arr[i][j] = arr[i-1][j];
                }else {
                    arr[i][j] = steps[i-1]+arr[i-1][j-steps[i-1]];
                }
            }
        }
        return arr[c-1][r-1];
    }
}
