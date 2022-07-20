package main.array;

import java.util.Arrays;

public class MergeTwoSortedArrayInSameArray {

    public static void mergeToA(int[] A, int aL, int[] B, int bL) {
        int a = aL - 1;
        int b = bL - 1;
        int c = aL + bL - 1;
        A = Arrays.copyOf(A, aL + bL);
        System.out.printf("New Length" + A.length);
        while (b >= 0 && a >= 0) {
            if (A[a] >= B[b]) {
                A[c--] = A[a--];
            } else {
                A[c--] = B[b--];
            }
        }

        while (b >= 0) {
            A[c--] = B[b--];
        }
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};

        mergeToA(arr1, arr1.length, arr2, arr2.length);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));

    }
}
