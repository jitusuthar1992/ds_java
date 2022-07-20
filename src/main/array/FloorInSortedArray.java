package main.array;

public class FloorInSortedArray {

    static int floorIndexLinearSearch(int key, int low, int high, int arr[]) {
        int i;


        int n = arr.length;
        if (arr[n - 1] <= key) {
            return n - 1;
        }

        for (i = 1; i < n; i++) {
            if (arr[i] > key) {
                return i - 1;
            }
        }
        return -1;
    }

    static int floorIndexBinarySearch(int key, int low, int high, int arr[]) {
        if (low > high)
            return -1;

        // If last element is smaller than x
        if (key >= arr[high])
            return high;

        // Find the middle point
        int mid = (low + high) / 2;

        // If middle point is floor.
        if (arr[mid] == key)
            return mid;

        // If x lies between mid-1 and mid
        if (mid > 0 && arr[mid - 1] <= key && key < arr[mid])
            return mid - 1;

        // If x is smaller than mid, floor must be in
        // left half.
        if (key < arr[mid])
            return floorIndexBinarySearch(key, low, mid - 1, arr);

        // If mid-1 is not floor and x is greater than
        // arr[mid],
        return floorIndexBinarySearch(key, mid + 1, high, arr);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};

        int x = 7;
        int index = floorIndexBinarySearch(x, 0, arr.length - 1, arr);
        if (index == -1)
            System.out.print("Floor of " + x + " doesn't exist in array ");
        else
            System.out.print("Floor of " + x + " is " + arr[index]);
    }
}
