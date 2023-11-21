/*
package main.greedy;

import jdk.nashorn.internal.scripts.JO;

import java.util.*;

public class ShortestJobFirst {
    static class Job {
        int id;
        int arrival;
        int burst;

        public Job(int id, int arrival, int burst) {
            this.id = id;
            this.arrival = arrival;
            this.burst = burst;
        }
    }

    static class JobComparator implements Comparator<Job>{

        @Override
        public int compare(Job j1, Job j2) {
            return j1.burst - j2.burst;
        }
    }

    private static int comp(Job j1,Job j2){
        return j1.burst - j2.burst;
    }
    private static void sjfScheduling(List<Job> jobs){

        Collections.sort(jobs,(j1,j2)->{
            if(j1.arrival == j2.arrival){
                if(j1.burst == j2.burst)
                    return j1.id - j2.id;
                return j1.burst - j2.burst;
            }
            return j1.arrival-j2.arrival;
        });

        int current_time = 0;
        int i =1;
        PriorityQueue<Job> pq = new PriorityQueue(new JobComparator());
        pq.add(jobs.get(0));
        List<Integer> answer = new ArrayList<>();
        while (!pq.isEmpty()){
            int burst = pq.peek().burst;
            int id = pq.peek().id;
            pq.poll();
            answer.add(id);
            current_time = current_time + burst;

            while (true){
                if (i < jobs.size() && jobs.get(i).arrival <= current_time ){
                    pq.add(jobs.get(i));
                    i++;
                }else {
                    break;
                }
            }
        }
        System.out.println("Scheduled jobs ids are : ");
        for (int j = 0; j < answer.size(); j++) {
            System.out.println(answer.get(j));
        }
    }

    public static void main(String[] args) {
        Job job = new Job(1,2,3);
        Job job1 = new Job(2,0,4);
        Job job2 = new Job(3,4,2);
        Job job3 = new Job(4,5,4);

        List<Job> jobs = Arrays.asList(job,job1,job2,job3);
        ShortestJobFirst.sjfScheduling(jobs);
    }
}
*/
