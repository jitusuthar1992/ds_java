package main.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallestUsingMinHeap(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static int kthSmallestUsingMaxHeap(int arr[], int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }


        return maxHeap.peek();
    }


    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int k = 3;

        System.out.println(KthSmallest.kthSmallestUsingMinHeap(arr, k));
        System.out.println(KthSmallest.kthSmallestUsingMaxHeap(arr, k));

    }
}
