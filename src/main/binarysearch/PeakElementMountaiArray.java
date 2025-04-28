package main.binarysearch;

public class PeakElementMountaiArray {
    public static void main(String[] args) {
        System.out.println("PeakElementMountaiArray :"+ new PeakElementMountaiArray().peakIndexInMountainArray(new int[]{0,1,0}));

    }

    int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
