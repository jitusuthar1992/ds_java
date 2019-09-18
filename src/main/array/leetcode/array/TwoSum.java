package main.array.leetcode.array;

import java.util.*;

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {


        Map<Integer,Integer> deltaIndexMap = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int delta = target - nums[i];
            if(deltaIndexMap.containsKey(delta)){
                return new int[]{deltaIndexMap.get(delta),i};
            }

            deltaIndexMap.put(nums[i],i);
        }

        return  new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int a[] = {2,5,3,7};
       // System.out.println();
        int[] sol = TwoSum.twoSum(a,9);
        for (int i = 0; i <sol.length ; i++) {
            System.out.println(sol[i]);

        }

    }

}
