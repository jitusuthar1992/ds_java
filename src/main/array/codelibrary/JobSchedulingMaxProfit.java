package main.array.codelibrary;

import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingMaxProfit {

    class Job {
        int start;
        int end;
        int profit;
    }
    int getmaxProfit(Job[] jobs){
        int n = jobs.length;

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));
        int profits[] = new int[n];
        profits[0] = jobs[0].profit;

        for (int i = 1; i <n ; i++) {
                int inc = jobs[i].profit;
                int last =-1;
                int low =0;
                int high = i-1;

                while (low <= high){
                    int mid = (low+high)/2;
                    if(jobs[mid].end <= jobs[i].start){
                        last = mid;
                        low = mid+1;
                    }else {
                        high = mid-1;
                    }
                }

                if(last !=-1){
                    inc+= profits[last];
                }
                int exc = profits[i-1];
                profits[i] = Math.max(inc,exc);
            }

        return profits[n-1];
    }
}
