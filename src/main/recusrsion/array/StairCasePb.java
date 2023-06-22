package main.recusrsion.array;

public class StairCasePb {

    public static void main(String args[])
    {
        int arr[] = { 1, 3, 5 };
        int len = arr.length;
        int n = 5;

        System.out.println(countWays(n, arr, len));
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
}
