package main.greedy;

import java.util.*;

public class MinCostCutBoard {
    public static int getMinCost(Integer hzcost[],Integer vtCost[]){
        int  ans = 0;
        int hzCount =1;
        int vtCount =1;
        int m = hzcost.length;
        int n = vtCost.length;
        int i =0,j=0;
        List<Integer> hzList = Arrays.asList(hzcost);
        List<Integer> vtList = Arrays.asList(hzcost);
        Collections.reverse(hzList);
        Collections.reverse(vtList);
        hzcost = (Integer[]) Arrays.stream(hzcost).toArray();
        vtCost = (Integer[]) Arrays.stream(hzcost).toArray();

        while (i<m && j <n){
            if(hzcost[i] > vtCost[j]){
                ans += hzcost[i] * vtCount;
                hzCount++;
                i++;
            }else {
                ans += vtCost[i] * hzCount;
                vtCount++;
                j++;
            }
        }
        while (i < m){
            ans += hzcost[i] * vtCount;
            i++;
        }
        while (j < n){
            ans += vtCost[i] * hzCount;
            j++;
        }
        return ans;
    }
}
