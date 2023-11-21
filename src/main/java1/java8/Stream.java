package main.java1.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2,
                "e", 5, "d", 4);
        LinkedHashMap<String,Integer> sortedMap = unsortedMap.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry:: getValue,
                        (oldValue,newValue)->oldValue,LinkedHashMap::new
                ));
        System.out.println(sortedMap);
    }
}
