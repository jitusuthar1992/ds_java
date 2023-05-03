package main.array.leetcode.array;

import java.util.Arrays;

public class TaskSchduler {
    public int leastInterval(char[] tasks, int n) {

        int freq[] = new int[26];
        for(int i =0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }

        Arrays.sort(freq);
        int chunk = freq[25]-1;
        int idleSpot = chunk * n;
        for(int j = 24;j>=0;j--){
            idleSpot -= Math.min(chunk,freq[j]);
        }
        return idleSpot <0 ? tasks.length : tasks.length + idleSpot;

    }
}
