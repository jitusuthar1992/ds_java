package main.array.codelibrary;

public class OnceElementSortedArray {
    static void search(int arr[], int n)
    {
        int ans = -1;
        for (int i = 0; i < n-1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                ans = arr[i];
                break;
            }
        }

        if (arr[n - 2] != arr[n - 1])
            ans = arr[n-1];

        // ans = -1 if no such element is present.
        System.out.println("The required element is "
                + ans);
    }
    static void search1(int arr[], int n)
    {
        int XOR = 0;
        for (int i = 0; i < n; i++) {
            XOR = XOR ^ arr[i];
        }
        System.out.println("The required element is "
                + XOR);
    }

    public static void search(int[] arr, int low, int high)
    {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is "
                    + arr[low]);
            return;
        }

        // Find the middle point
        int mid = (low + high) / 2;

        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
                search(arr, mid + 2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high);
            else
                search(arr, low, mid - 1);
        }
    }
}
