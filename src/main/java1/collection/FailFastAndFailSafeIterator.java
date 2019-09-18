package main.java1.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafeIterator {

    public static void main(String[] args) {

        //fail fast
        List<String> list = new ArrayList<>();
        list.add("1");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String s = (String) iterator.next();
            if(s.equals("1")){
                list.remove(s);
                iterator.remove();

            }
        }

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list.add("1");

        Iterator iterator1 = list1.iterator();
        while (iterator1.hasNext()){
            String s = (String) iterator1.next();
            if(s.equals("1")){
                list.remove(s);
            }
        }
    }
}
