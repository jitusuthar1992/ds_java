package main.array;

public class SearchInSortedRotatedArraySol2 {

    private static int search(int arr[], int target) {
        int n = arr.length;
        int high = n - 1, low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && arr[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[low] >= target && arr[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 2, 2, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : "
                + search(arr1, key));
    }
}
