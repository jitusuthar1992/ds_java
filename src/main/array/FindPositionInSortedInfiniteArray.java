package main.array;

public class FindPositionInSortedInfiniteArray {
    static int binarySearch(int l, int r, int key, int arr[]) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return binarySearch(l, mid - 1, key, arr);
            } else {
                return binarySearch(mid + 1, r, key, arr);
            }
        }
        return -1;

    }


    static int findPos(int key, int arr[]) {
        int l = 0, h = 1;
        int val = arr[0];

        while (val < key) {
            l = h;

            if (2 * h < arr.length - 1) {
                h = 2 * h;
            } else {
                h = arr.length - 1;
            }

            val = arr[h];
        }

        return binarySearch(l, h, key, arr);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findPos(10, arr);

        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

}
