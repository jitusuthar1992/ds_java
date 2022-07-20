package main.lru;

import java.util.*;

public class LRUCacheImpl {
    private Deque<Node> cache;

    private Map<Integer, Node> map;

    int cSize;

    static class Node {
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + '}';
        }
    }

    LRUCacheImpl(int n) {
        cache = new LinkedList<>();
        map = new HashMap<Integer, Node>();
        cSize = n;
    }


    public Integer get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
            return node.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            node.value = value;
            cache.addLast(node);

        } else {
            Node node = new Node(key, value);
            if (map.size() == cSize) {
                cache.removeLast();
            }
            cache.addLast(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        LRUCacheImpl lrucache = new LRUCacheImpl(4);
        lrucache.put(1, 1);
        lrucache.put(10, 15);
        lrucache.put(15, 10);
        lrucache.put(10, 16);
        lrucache.put(12, 15);
        lrucache.put(18, 10);
        lrucache.put(13, 16);
        Iterator it = lrucache.cache.iterator();


        while (it.hasNext()) {
            System.out.println(it.next());
        }
        /*System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));*/

    }

}
