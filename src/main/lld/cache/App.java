package main.lld.cache;

import main.lld.cache.factories.CacheFactory;

public class App {
    public static void main(String[] args) {
        Cache<Integer,String> cache =  new CacheFactory<Integer,String>().defaultcache();
        cache.put(1,"Jitendra");
        cache.put(2,"Ankit");
        cache.put(3,"Rakesh");

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
