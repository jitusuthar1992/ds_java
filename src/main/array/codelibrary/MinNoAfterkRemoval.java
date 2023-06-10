package main.array.codelibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an array of items, an i-th index element denotes the item id’s, and given a number m, the task is to remove m elements
such that there should be minimum distinct id’s left. Print the number of distinct id’s.
*/
public class MinNoAfterkRemoval {
    public static int minNumber(int arr[], int k){
      Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
           int count = countMap.getOrDefault(arr[i],0);
           countMap.put(arr[i],count+1 );
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer freq: countMap.values()) {
            pq.add(freq);
        }

        while (!pq.isEmpty() && k >0){
            k-= pq.poll();
        }
        return k < 0 ? pq.size()+1 : pq.size();
    }
    public static void main(String[] args)
    {
        int arr[] = { 2, 4, 1, 5, 3, 5, 1, 3 };
        int m = 2;

        System.out.println(MinNoAfterkRemoval.minNumber(arr, m));
    }
}
