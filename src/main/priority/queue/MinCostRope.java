package main.priority.queue;

import java.util.PriorityQueue;

public class MinCostRope {
    public static int findMinCost(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int ans = 0;
        while (pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,4,8,6,9};
        System.out.println("Min cost : "+findMinCost(arr));
    }
}
