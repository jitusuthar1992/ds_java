package main.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinCntCharDeletionsfrequency {
    static int minCntCharDeletionsfrequency(char[] str,
                                            int N) {
        HashMap<Character, Integer> map = new HashMap<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        int cntChar = 0;

        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                map.put(str[i],
                        map.get(str[i]) + 1);
            } else {
                map.put(str[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        while (!pq.isEmpty()) {
            int freq = pq.peek();

            pq.remove();
            if (pq.isEmpty())
                return cntChar;
            if (freq == pq.peek()) {
                if (freq > 1) {
                    pq.add(freq - 1);
                }
                cntChar++;
            }
        }
        return cntChar;
    }

    public static void main(String[] args) {
        String str = "abbbcccd";

        // Stores length of str
        int N = str.length();
        System.out.print(minCntCharDeletionsfrequency(
                str.toCharArray(), N));
    }
}
