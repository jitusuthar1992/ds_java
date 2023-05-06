package main.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Node implements Comparable<Node> {
        int data;
        int i ;
        int j;

        public Node(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }
    public static void mergeKArraysSol1(int[][] arr, int a,
                                        int[] output) {
        int c = 0;

        // traverse the matrix
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 4; j++)
                output[c++] = arr[i][j];
        }

        // sort the array
        Arrays.sort(output);
    }

    public static void mergeKArraysSol2(int[][] arr, int k,
                                        int[] output) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int c =0;
        for (int i = 0; i <k ; i++) {
            Node tmp = new Node(arr[i][0],i,0);
            pq.add(tmp);
        }



        while (pq.size() > 0){
            Node node = pq.poll();
            output[c++] = node.data;
            int i = node.i;
            int j= node.j;

            if(arr[i].length > j+1){
                Node next = new Node(arr[i][j+1],i,j+1);
                pq.add(next);
            }
        }
    }

    // A utility function to print array elements
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver's code
    public static void main(String[] args) {
        int[][] arr = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        int K = 4;
        int N = 3;
        int[] output = new int[N * K];

        // Function call
        mergeKArraysSol2(arr, N, output);

        System.out.println("Merged array is ");
        printArray(output, N * K);
    }

}
