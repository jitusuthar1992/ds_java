package main.binarysearch;

public class PivotElement {
    public static void main(String[] args) {
        System.out.println("PivotElement Index:"+ new PivotElement().pivotIndex(new int[]{3,8,10,17,1}));
    }
    int pivotIndex(int[] nums) {
        int size = nums.length;
        int start = 0;;
        int end = size - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {

            if (nums[mid] >= nums[0]) {
                start = mid+1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }
}
