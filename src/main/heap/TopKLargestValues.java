package main.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestValues {
    public static List<Integer> findKLargestNumbersUsingMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            l.add(maxHeap.poll());
        }

        return l;
    }

    public static List<Integer> findKLargestNumbersUsingMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i <k; i++) {
            minHeap.add(arr[i]);
        }

        for(int i = k; i <arr.length; i++) {
            if(arr[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            l.add(minHeap.poll());
        }

        return l;
    }
    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 30, 8, 38, 2, 45};
        int k = 3;

        System.out.println(TopKLargestValues.findKLargestNumbersUsingMinHeap(arr, k));

        System.out.println(TopKLargestValues.findKLargestNumbersUsingMaxHeap(arr, k));

    }

}
