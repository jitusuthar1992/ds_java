package main.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jitendra.kumar01
 * 09/11/19
 */
public class LargestSubArrayWithEquals0S1S {

    int findSubArray(int arr[], int n)
    {
        int sum =0 ;
        int maxSize =-1;
        int startIndex =0;
        int endIndex =0;

        for (int i = 0; i <n ; i++) {
            sum += arr[i]==0 ?-1 :1;

            for (int j = i+1; j <n ; j++) {
                sum += arr[j]==0 ?-1 :1;

                if(sum ==0 && maxSize < j-i+1)
                {
                    maxSize = j-i+1;
                    startIndex =i;
                }
            }

        }

        endIndex = startIndex +maxSize -1;

        if (maxSize == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startIndex+" to "+endIndex);

        return maxSize;
    }

    public static void main(String[] args)
    {
        LargestSubArrayWithEquals0S1S sub;
        sub = new LargestSubArrayWithEquals0S1S();
        int arr[] = {0, 0, 0, 1, 0, 1, 1};
        int size = arr.length;

        //sub.findSubArray(arr, size);
        sub.maxLenSubarray(arr);
    }

    public static void maxLenSubarray(int[] A)
    {
        // create an empty Hash Map to store ending index of first
        // sub-array having some sum
        Map<Integer, Integer> map = new HashMap<>();

        // insert (0, -1) pair into the set to handle the case when
        // sub-array with sum 0 starts from index 0
        map.put(0, -1);

        // len stores the maximum length of sub-array with sum 0
        int len = 0;

        // stores ending index of maximum length sub-array having sum 0
        int ending_index = -1;

        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < A.length; i++)
        {
            // sum of elements so far (replace 0 with -1)
            sum += (A[i] == 0)? -1: 1;

            // if sum is seen before
            if (map.containsKey(sum))
            {
                // update length and ending index of maximum length
                // sub-array having sum 0
                if (len < i - map.get(sum))
                {
                    len = i - map.get(sum);
                    ending_index = i;
                }
            }
            // if sum is seen for first time, insert sum with its
            // index into the map
            else {
                map.put(sum, i);
            }
        }

        // print the sub-array if present
        if (ending_index != -1) {
            System.out.println("[" + (ending_index - len + 1) + ", " +
                                       ending_index + "]");
        }
        else {
            System.out.println("No sub-array exists");
        }
    }

}
