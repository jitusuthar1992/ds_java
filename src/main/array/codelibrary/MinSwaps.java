package main.array.codelibrary;

import java.util.Arrays;
import java.util.Comparator;

import static main.bitmanupulation.Swap2Nos.swap;

public class MinSwaps {
    public static int minSwap(int arr[]){
        int n =arr.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i <n ; i++) {
            nodes[i] = new Node(i,arr[i]);
        }
        int c=0;
        Arrays.stream(nodes).sorted(Comparator.comparingInt(o -> o.value));

        for (int i = 0; i <n ; i++) {
            if(i == nodes[i].index ){
                continue;
            }
            c++;
            swap(arr[i],arr[nodes[i].index]);
            i--;
        }
        return c;
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
