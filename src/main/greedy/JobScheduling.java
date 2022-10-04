package main.greedy;

import java.util.*;

public class JobScheduling {
    static class Job {
        int jobId;

        int deadLine;
        int profit;

        public Job(int jobId, int deadLine, int profit) {
            this.jobId = jobId;
            this.profit = profit;
            this.deadLine = deadLine;
        }
    }

    private int getMaxProfit(List<Job> jobs){
        Collections.sort(jobs, (a,b)->{
           return b.profit- a.profit;
        });
        boolean[] done = new boolean[jobs.size()];
        int day =0;
        int profit =0;
        for (int i = 0; i <jobs.size() ; i++) {
            for (int j = Math.min(jobs.size(),jobs.get(i).deadLine -1); j >=0 ; j--) {
                if(!done[j]){
                    done[j] = true;
                    profit+= jobs.get(i).profit;
                    day++;
                    break;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Job job= new Job(1,4,20);
        Job job1= new Job(2,1,10);
        Job job2= new Job(3,1,40);
        Job job3= new Job(4,1,30);
        List<Job> jobs =new ArrayList<>();
        jobs.add(job);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        System.out.println("Max Profit " + new JobScheduling().getMaxProfit(jobs));
    }

}
