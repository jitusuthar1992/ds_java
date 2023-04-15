package main.priority.queue;

import java.util.PriorityQueue;

public class KthLargestElement {

    public  static int findKthLargest(int[] a, int k){
        if(a.length < k){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <k ; i++) {
            pq.add(a[i]);
        }

        for (int i = k; i < a.length ; i++) {
            if(pq.peek() < a[i]){
                pq.poll();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int arr[] ={20,10,60,30,40,50};
        System.out.println("Kth Largest Element is "+findKthLargest(arr,3));
    }
}
