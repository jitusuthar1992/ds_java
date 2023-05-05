package main.array.leetcode.array;

public class ZeroFilledSubArray {
    public static int getCount(int nums[]){
        int res = 0, counter = 0;
        for (int num: nums) {
            if(num ==0){
                counter++;
            }else {
                res += (counter*(counter+1))/2;
            }
        }
        if(counter !=0){
            res += (counter*(counter+1))/2;
        }
        return res;
    }
}
