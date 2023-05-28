package main.priority.queue;

import java.util.*;

public class GameStringMinSum {
    public static int getMinSum(String str, int k){
        int n = str.length();
        Map<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character ch = str.charAt(i);
            if(freq.get(ch) == null){
                freq.put(ch,1);
            }else {
                int c =freq.get(ch) +1;
                freq.put(ch,c);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        List<String> list = new ArrayList<>();

        for (Integer f :freq.values()) {
            pq.add(f);
        }

        while (k != 0){
            int f = pq.peek();
            pq.poll();
            f--;
            pq.add(f);
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()){
            int x = pq.peek();
            pq.poll();
            sum  += (x*x);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(GameStringMinSum.getMinSum("abccc",1));
    }
}
