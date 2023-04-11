package main.lld.cache;

import main.lld.cache.exception.NotFoundException;
import main.lld.cache.exception.StorageFullException;


public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            System.out.println("Got Storage full, trying to evict the key");
            Key evictKey = this.evictionPolicy.evictKey();
            if (null == evictKey) {
                throw new RuntimeException("Unexpected State. No storage and no key to evict");
            }
            this.storage.remove(evictKey);
            put(key, value);

        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException e) {
            throw new RuntimeException("Tried to access non existing key");
        }
    }
}
