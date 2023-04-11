package main.lld.cache.impl;

import main.lld.cache.exception.NotFoundException;
import main.lld.cache.Storage;
import main.lld.cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    private final Integer MAX_SIZE = 5;

    private AtomicInteger size = new AtomicInteger(0);
    private Map<Key, Value> cache = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (size.get() >= MAX_SIZE) {
            throw new StorageFullException();
        }
        size.incrementAndGet();
        cache.put(key, value);

    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (null == cache.get(key)) {
            throw new NotFoundException();
        }
        return cache.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (null == cache.get(key)) {
            throw new NotFoundException();
        }
        size.decrementAndGet();
        cache.remove(key);
    }
}
