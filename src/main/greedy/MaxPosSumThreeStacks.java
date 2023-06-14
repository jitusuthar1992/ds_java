package main.greedy;

import java.util.Arrays;

public class MaxPosSumThreeStacks {
    public static int getMaxSum(int st1[], int st2[], int st3[]){
        int n1 = st1.length ,  n2 = st2.length , n3 = st3.length;

        int sum1 = Arrays.stream(st1).sum();
        int sum2 = Arrays.stream(st2).sum();
        int sum3 = Arrays.stream(st3).sum();
        int top1 = 0, top2 =0, top3 = 0;
        int ans =0;

        while (true){
            if(top1 ==n1 || top2 ==n2 || top3 ==n3){
                ans = 0;
                break;
            }

            if(sum1 ==sum2 && sum2 == sum3){
                ans = sum1;
                break;
            }

            if(sum1 >= sum2 && sum1 >= sum3){
                sum1 -= st1[top1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= st2[top2++];
            } else if (sum3 >= sum2 && sum3 >= sum1) {
                sum3 -= st3[top3++];
            }
        }
        return ans;
    }
}
