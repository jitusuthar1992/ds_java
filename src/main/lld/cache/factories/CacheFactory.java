package main.lld.cache.factories;

import main.lld.cache.Cache;
import main.lld.cache.impl.HashMapBasedStorage;
import main.lld.cache.impl.LRUEvictionPolicy;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultcache() {
        return new Cache<Key, Value>(new LRUEvictionPolicy<>(), new HashMapBasedStorage<>());
    }
}
