package main.array;

public class MaxProductSubArray {
    private static  int getMaxProduct(int arr[]){

        int ans = arr[0];
        int ma = ans;
        int mi = ans;

        for (int i = 1; i < arr.length ; i++) {
            if(arr[i] < 0){
                int temp = ma ;
                ma = mi ;
                mi = temp;
            }
            ma = Math.max(arr[i], ma* arr[i]);
            mi = Math.min(arr[i], mi* arr[i]);
            ans = Math.max(ans ,ma);
        }
        return ans;
    }
}
