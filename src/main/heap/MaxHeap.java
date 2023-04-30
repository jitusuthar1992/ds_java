package main.heap;

import java.util.Arrays;

public class MaxHeap {
    int heap[] = new int[100];
    int size;

    void insertElement(int val){
        this.size += 1;
        int n = this.size-1;
        heap[n] = val;
        int i = n;
        while (i > 0){
            int parant = (i-1)/2;
            if(this.heap[parant] < this.heap[i]){
                int temp = this.heap[i];
                this.heap[i] = this.heap[parant];
                this.heap[parant] = temp;
                i = parant;
            }else {
                return;
            }
        }
    }

    void buildmaxHeap(int arr[]){
        this.heap = Arrays.copyOfRange(arr,0,arr.length-1);
        this.size= this.heap.length;
        for (int i = this.size/2; i >=0 ; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int l, r;

        l = 2 * i + 1;
        r = 2 * i + 2;

        int largest = i;

        if (l < this.size && this.heap[l] > this.heap[largest]) {
            largest = i;
        }

        if (r < this.size && this.heap[r] > this.heap[largest]) {
            largest = r;
        }

        if (i != largest) {
            int temp = this.heap[i];
            this.heap[i] = this.heap[largest];
            this.heap[largest] = temp;
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int arr[] = {10,30,50,20,35,15};
        maxHeap.buildmaxHeap(arr);

        System.out.println("Max Heap");
        for (int i = 0; i < maxHeap.heap.length ; i++) {
            System.out.println(maxHeap.heap[i]);
        }

        maxHeap.insertElement(69);
        System.out.println("Max Heap");
        for (int i = 0; i < maxHeap.heap.length ; i++) {
            System.out.println(maxHeap.heap[i]);
        }
    }
}
