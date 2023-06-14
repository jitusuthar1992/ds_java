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

    private static  int getMaxProductSol2(int arr[]){

        int ans = arr[0];

        for (int i = 0; i < arr.length ; i++) {
           int mul = arr[i];
            for (int j = i+1; j <arr.length ; j++) {
                ans = Math.max(ans ,mul);
                mul *=arr[j];
            }
            ans = Math.max(ans ,mul);
        }
        return ans;
    }

}
