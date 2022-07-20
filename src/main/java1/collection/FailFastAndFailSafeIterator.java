package main.java1.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafeIterator {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map);
        map.put(null, null);
        map.put(null, null);
        //map.keySet().add("1");
        System.out.println(map);
        //System.out.println(map);
        ///fail fast
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        //list.add(2,"1");

        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            String s = (String) iterator1.next();
            if (s.equals("1")) {
                list.remove(s);
            }
        }

        //Exception in thread "main" java.util.ConcurrentModificationException
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            if (s.equals("1")) {
                list.remove(s);
                iterator.remove();

            }
        }

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list.add("1");

        Iterator iterator2 = list1.iterator();
        while (iterator2.hasNext()) {
            String s = (String) iterator2.next();
            if (s.equals("1")) {
                iterator.remove();
            }
        }


        ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

        // use add() method to add elements in the list
        arrlist.add(10);
        arrlist.add(22);
        arrlist.add(30);
        arrlist.add(40);

        // adding element 35 at fourth position
        // arrlist.add(5, 35);

        // let us print all the elements available in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }


    }

}

class AbstractClassExample {

    int method() {
        return 0;
    }
}

class AbstractClassExample1 extends AbstractClassExample {
    int method() {
        return 0;
    }
}

