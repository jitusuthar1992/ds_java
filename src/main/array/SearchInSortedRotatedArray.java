package main.array;

public class SearchInSortedRotatedArray {
    static int pivotBinarySearch(int arr[], int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);

        if (pivot == -1) {
            return binarySearch(arr, 0, n - 1, key);
        }
        if (arr[pivot] == key) {
            return pivot;
        }
        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot - 1, key);
        }
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    static int findPivot(int[] arr, int s, int e) {
        if (e < s) {
            return -1;
        }
        if (e == s) {
            return s;
        }

        int mid = (s + e) / 2;

        if (arr[mid] > arr[mid + 1]) {
            return mid + 1;
        } else {
            if (arr[s] > arr[mid]) {
                return findPivot(arr, s, mid - 1);
            }
            return findPivot(arr, mid + 1, e);
        }

    }

    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static void main(String args[]) {
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 2, 2, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : "
                + pivotBinarySearch(arr1, n, key));

        int arr[] = {4, 5, 6, 7, 8, 2, 2, 2, 3};

        int i = search(arr, 0, arr.length - 1, 3);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }
}
