package main.sorting;

import java.util.Arrays;


/*For simplicity, consider the data in the range 0 to 9.
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index
  stores the sum of previous counts.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in
the output sequence.

  3) Output each object from the input sequence followed by
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place
  next data 1 at an index 1 smaller than this index.
  */

public class CountSort {


    static void sort(int k, int[] a) {
        int[] count = new int[k + 1];
        Arrays.fill(count, 0);
        int outPut[] = new int[a.length];

        for (int i = 0; i < a.length; i++)
            ++count[a[i]];
        for (int i = 1; i <= k; i++)
            count[i] += count[i - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            outPut[count[a[i]] - 1] = a[i];
            --count[a[i]];
        }
        for (int i = 0; i < a.length; i++)
            System.out.println(outPut[i]);


    }

    public static void main(String[] args) {
        int a[] = {2, 4, 1, 5, 1, 4, 3, 5};
        sort(5, a);

    }
}
