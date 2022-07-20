package main.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jitendra.kumar01
 * 06/02/20
 */
public class CountFrequency {

    public static void countFreqSol1(int arr[], int n) {
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (visited[i] == true) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println("Frequncy of " + arr[i] + " is :" + count);

        }
    }

    public static void countFreqSol2(int arr[], int n) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            countMap.put(arr[i], countMap.get(arr[i]) == null ? 1 : countMap.get(arr[i]) + 1);

        }


        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Frequncy of " + entry.getKey() + " is :" + entry.getValue());
        }
    }

    public static void countFreqWithSameOrder(int arr[], int n) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            countMap.put(arr[i], countMap.get(arr[i]) == null ? 1 : countMap.get(arr[i]) + 1);

        }

        for (int i = 0; i < n; i++) {
            if (countMap.get(arr[i]) != -1) {
                System.out.println("Frequncy of " + arr[i] + " is :" + countMap.get(arr[i]));
                countMap.put(arr[i], -1);
            }
        }

    }

    /**
     * Given an unsorted array of n integers which can contain integers from 1 to n.
     * Some elements can be repeated multiple times and
     * some other elements can be absent from the array.
     * Count frequency of all elements that are present and print the missing elements.
     * Count frequencies of all elements in array in O(1) extra space and O(n) time
     */

    public static void findCounts(int arr[], int n) {
        int i = 0;

        while (i < n) {

            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            } else {
                // If this is NOT first occurrence of arr[i],
                // then decrement its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }
        System.out.println("Below are counts of all elements");
        for (int j = 0; j < n; j++)
            System.out.println(j + 1 + "->" + Math.abs(arr[j]));


    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int size = arr.length;
        countFreqSol1(arr, size);

        System.out.println();

        countFreqSol2(arr, size);

        System.out.println();

        countFreqWithSameOrder(arr, size);

        System.out.println();

        int arr1[] = {2, 3, 3, 2, 5};
        findCounts(arr1, arr1.length);

        System.out.println("List test cases");
        List<Boolean> lists = new ArrayList<>();
        lists.add(false);
        System.out.println(lists.contains(false));
    }
}
