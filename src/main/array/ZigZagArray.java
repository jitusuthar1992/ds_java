package main.array;

import java.util.Arrays;

public class ZigZagArray {


    // Method for zig-zag conversion of array
    static void zigZag(int arr[]) {

        boolean flag = true;
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag;
        }
    }


    // Driver method to test the above function
    public static void main(String[] args) {
        int arr[] = new int[]{4, 3, 7, 8, 6, 2, 1};
        zigZag(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static class FirstAndLastOccurence {
        public static int first(int arr[], int low, int high, int x, int n) {
            if (high >= low) {
                int mid = low + (high - low) / 2;
                if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                    return mid;
                else if (x > arr[mid])
                    return first(arr, (mid + 1), high, x, n);
                else
                    return first(arr, low, (mid - 1), x, n);
            }
            return -1;
        }

        /* if x is present in arr[] then returns the index of
        LAST occurrence of x in arr[0..n-1], otherwise
        returns -1 */
        public static int last(int arr[], int low, int high, int x, int n) {
            if (high >= low) {
                int mid = low + (high - low) / 2;
                if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                    return mid;
                else if (x < arr[mid])
                    return last(arr, low, (mid - 1), x, n);
                else
                    return last(arr, (mid + 1), high, x, n);
            }
            return -1;
        }

        static int count(int arr[], int x, int n) {
            // index of first occurrence of x in arr[0..n-1]
            int i;

            // index of last occurrence of x in arr[0..n-1]
            int j;

            /* get the index of first occurrence of x */
            i = first(arr, 0, n - 1, x, n);

            /* If x doesn't exist in arr[] then return -1 */
            if (i == -1)
                return i;

          /* Else get the index of last occurrence of x.
             Note that we are only looking in the
             subarray after first occurrence */
            j = last(arr, i, n - 1, x, n);

            /* return count */
            return j - i + 1;
        }

        public static void main(String[] args) {

            int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
            int n = arr.length;
            int x = 2;
            System.out.println("First Occurrence = " + first(arr, 0, n - 1, x, n));
            System.out.println("Last Occurrence = " + last(arr, 0, n - 1, x, n));

            int arr1[] = {1, 2, 2, 3, 3, 3, 3};

            // Element to be counted in arr[]
            int x1 = 3;
            int n1 = arr1.length;
            int c = count(arr1, x1, n1);
            System.out.println(x1 + " occurs " + c + " times");

        }


    }
}
