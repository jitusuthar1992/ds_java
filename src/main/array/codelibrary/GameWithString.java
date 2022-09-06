package main.array.codelibrary;

import java.util.*;

public class GameWithString {
    private int getMin(String input ,int k) {

        Map<Character, Integer> countChars = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (countChars.containsKey(ch)) {
                countChars.put(ch, countChars.get(ch) + 1);
            } else {
                countChars.put(ch, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                Collections.reverseOrder());;
        for (Map.Entry<Character,Integer> entry : countChars.entrySet()){
            pq.add(entry.getValue());
        }

        while (k!=0){
            int x = pq.peek();
            pq.poll();
            x--;
            pq.add(x);
            k--;
        }
        int sum =0;
        while (!pq.isEmpty()){
            int d = pq.peek();
            sum= sum+ (d*d);
            pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum = "+new GameWithString().getMin("aaabbbbccccc",3));
    }
}
