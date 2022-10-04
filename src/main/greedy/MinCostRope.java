package main.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinCostRope {
    private static int getMinCost(int[] ropes , int n){
        if(n==1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(ropes).forEach(rope->pq.add(rope));
        int ans = 0;
        while (pq.size() >1){
            int rp1 = pq.peek();
            pq.poll();
            int rp2 = pq.peek();
            pq.poll();
            ans += (rp1 + rp2);
            pq.add((rp1 + rp2));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Min Cost : "+MinCostRope.getMinCost(new int[]{4,3,2,6},4));
    }
}
