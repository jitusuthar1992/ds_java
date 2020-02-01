package main.java1.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author jitendra.kumar01
 * 27/01/20
 */
public class ForEach {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Consumer<Integer> action =System.out::println;
        numberList.stream().filter(n->n%2 == 0).forEach(action);
        numberList.forEach(action);


        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        //1. Map entries
        Consumer<Map.Entry<String, Integer>> actions = System.out::println;

        map.entrySet().forEach(actions);

        //2. Map keys
        Consumer<String> actionOnKeys = System.out::println;

        map.keySet().forEach(actionOnKeys);

        //3. Map values
        Consumer<Integer> actionOnValues = System.out::println;

        map.values().forEach(actionOnValues);


        //custom action


        Consumer<Map.Entry<String, Integer>> action1 = entry ->
        {
            System.out.println("Key is : " + entry.getKey());
            System.out.println("Value is : " + entry.getValue());
        };

        map.entrySet().forEach(action1);

    }
}
