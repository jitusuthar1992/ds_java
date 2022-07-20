package main.array;

/*
Given an array arr[] of integers, find out the maximum difference
between any two elements such that larger element appears after the
smaller number.
*/
public class MaxDifference {

    /*
    Use two loops. In the outer loop, pick elements one by one and
    in the inner loop calculate the difference of the picked element
    with every other element in the array and compare the difference
    with the maximum difference calculated so far.
    */
    int maxDiff(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int i, j;
        for (i = 0; i < arr_size; i++) {
            for (j = i + 1; j < arr_size; j++) {
                if (arr[j] - arr[i] > max_diff)
                    max_diff = arr[j] - arr[i];
            }
        }
        return max_diff;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        MaxDifference maxdif = new MaxDifference();
        int arr[] = {1, 2, 90, 10, 110};
        System.out.println("Maximum differnce is " +
                maxdif.maxDiff(arr, 5));
    }

/*In this method, instead of taking difference of the picked
element with every other element, we take the difference with
the minimum element found so far. So we need to keep track of 2
things:
    1) Maximum difference found so far (max_diff).
    2) Minimum number visited so far (min_element)*/

    int maxDiffSol2(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    /*
    Like min element, we can also keep track of max element
    from right side. Thanks to Katamaran for suggesting this
    approach.
    */
    int maxDiffSol3(int arr[], int n) {
        // Initialize Result
        int maxDiff = -1;

        // Initialize max element from right side
        int maxRight = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight)
                maxRight = arr[i];
            else {
                int diff = maxRight - arr[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
    }
}
