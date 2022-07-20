package main.heap;

import java.util.*;

public class SortStringBasedOnFrequencyOfCharacters {

    public static List<Character> sortStringBasedOnFrequencyOfCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());

        maxHeap.addAll(map.entrySet());

        List<Character> list = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            list.add(entry.getKey());

        }

        return list;
    }

    public static void main(String[] args) {
        String str = "codingsimplified";

        System.out.println(SortStringBasedOnFrequencyOfCharacters.sortStringBasedOnFrequencyOfCharacters(str));
    }

}
