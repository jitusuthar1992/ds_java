package main.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapImplUsingPriorityQueue {
    public static void minHeap(int arr[]){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <arr.length ; i++) {
            minHeap.add(arr[i]);
        }

        System.out.println("Min Heap Elements");

        while (!minHeap.isEmpty()){
            System.out.print(minHeap.poll() +" ");
        }

        System.out.println();

    }

    public static void maxHeap(int arr[]){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i <arr.length ; i++) {
            maxHeap.add(arr[i]);
        }

        System.out.println("MAX Heap Elements");

        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll() +" ");
        }

        System.out.println();


    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 11, 5, 2, 13, 1, 45};

        HeapImplUsingPriorityQueue.minHeap(arr);

        HeapImplUsingPriorityQueue.maxHeap(arr);



    }
}
