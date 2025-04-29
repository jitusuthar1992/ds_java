package main.binarysearch;

public class FindFirstOccurence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        int target = 3;
        System.out.println("First Index:"+ new FindFirstOccurence().findFirst(arr,target));
    }

    public String findFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if(arr[mid] == target){
                ans = mid;
                end = mid -1;
            }else if (arr[mid] < target){
                start = mid+1;
            } else if (arr[mid] > target ) {
                end = mid -1;
            }
            mid = start + (end - start) / 2;
        }
        return ans == -1 ? "Not Found" : String.valueOf(ans);
    }
}
