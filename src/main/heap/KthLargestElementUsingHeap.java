package main.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementUsingHeap {
    public static int kthLargestUsingMinHeap(int arr[], int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i <k ; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i <arr.length ; i++) {
            if(arr[i]> minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        return minHeap.peek();
    }

    public static int kthLargestUsingMaxHeap(int arr[], int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i <arr.length ; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = 0; i <k-1 ; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
        int k = 3;

        System.out.println(KthLargestElementUsingHeap.kthLargestUsingMaxHeap(arr, k));
        System.out.println(KthLargestElementUsingHeap.kthLargestUsingMinHeap(arr, k));


    }
}
