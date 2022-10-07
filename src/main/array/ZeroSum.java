package main.array;

public class ZeroSum {
    private static boolean isZeroSumAvailable(int arr[]){
        boolean visited[] = new boolean[arr.length];
        int sum = 0, f =0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
            if(sum ==0 || visited[i] || arr[i] ==0){
                f =1;
                break;
            }else {
                visited[i] = true;
            }
        }
        if( f== 1)
            return true;
        return false;
    }
}
