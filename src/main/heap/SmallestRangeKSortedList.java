package main.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestRangeKSortedList {

    class Node implements Comparable<Node> {
        int data;
        int row;
        int col;

        public Node(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo( Node o) {
            return this.data - o.data;
        }
    }
    public int[] findRange(int[][] arr, int k){
                int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
                PriorityQueue<Node> minHeap = new PriorityQueue<>();
                for (int i = 0; i < k; i++) {
                    min = Math.min(min,arr[i][0]);
                    max = Math.max(max,arr[i][0]);
                    minHeap.add(new Node(arr[i][0],i,0));
                }

                int start = min , end = max;
                while (!minHeap.isEmpty()){
                    Node temp = minHeap.poll();
                    int data = temp.data;
                    int row = temp.row;
                    int col = temp.col;
                    min = data;
                    if(max - min < end -start){
                        end = max;
                        start = min;
                    }
                    if(col+1 < arr[row].length){
                        max = Math.max(max,arr[row][col+1]);
                        minHeap.add(new Node(arr[row][col+1],row,col+1));
                    }else {
                        break;
                    }
                }
                return new int[]{end,start};
    }

    public static void main(String[] args) {
        int[][] arr ={{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        System.out.println(new SmallestRangeKSortedList().findRange(arr,3));
    }
}
