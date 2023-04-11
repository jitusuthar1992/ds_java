package main.lld.cache;

import main.lld.cache.factories.CacheFactory;

public class App {
    public static void main(String[] args) {
        try {
            Cache<Integer, String> cache = new CacheFactory<Integer, String>().defaultcache();
            cache.put(1, "Jitendra");
            cache.put(2, "Ankit");
            cache.put(3, "Rakesh");
            cache.put(4, "Arvind");
            cache.put(5, "Ajay");
            cache.put(6, "Amit");

            System.out.println(cache.get(6));
            System.out.println(cache.get(5));
            System.out.println(cache.get(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
