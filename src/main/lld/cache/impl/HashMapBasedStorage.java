package main.lld.cache.impl;

import main.lld.cache.exception.NotFoundException;
import main.lld.cache.Storage;
import main.lld.cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {

    private Map<Key,Value> cache = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        cache.put(key,value);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return cache.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        cache.remove(key);
    }
}
