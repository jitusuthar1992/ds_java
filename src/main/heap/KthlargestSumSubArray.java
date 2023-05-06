package main.heap;

import java.util.PriorityQueue;

public class KthlargestSumSubArray {
    public static int getKthlargestSum(int nums[],int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length ; i++) {
            int sum = 0;
            for (int j = i; j < nums.length ; j++) {
                sum+=nums[j];
                if(minHeap.size() < k){
                    minHeap.add(sum);
                }else if(minHeap.peek() < sum){
                    minHeap.poll();
                    minHeap.add(sum);
                }
            }

        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int nums[] = {1,2,6,4,3};
        System.out.println(KthlargestSumSubArray.getKthlargestSum(nums,3));
    }
}
