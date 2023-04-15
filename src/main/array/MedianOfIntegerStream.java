package main.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfIntegerStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insertElement(Integer e){
        if(maxHeap.isEmpty() || e <= maxHeap.peek() ){
            maxHeap.add(e);
        }else {
            minHeap.add(e);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size() ) {
            maxHeap.add(minHeap.poll());
        }
    }

    public  Integer getMedian(){
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2 + minHeap.peek()/2;
        }
        return maxHeap.peek();

    }

    public static void main(String[] args) {

    }
}
