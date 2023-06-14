package main.greedy;

public class MaxProductSubset {
    public static int maxproduct(int arr[]){
        int n = arr.length;
        int zeroCount =0;
        int negCount =0;
        int prod =1;
        int maxNeg = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==0){
                zeroCount++;
                continue;
            } else if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg,arr[i]);
            }
            prod *= arr[i];
        }

        if(zeroCount == n ){
            return 0;
        }else if (negCount ==1 && zeroCount + negCount == n){
            return 0;
        }else if((negCount & 1) !=0){
            prod = prod/maxNeg;
        }
        return prod;
    }
}
