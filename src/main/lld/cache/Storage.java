package main.lld.cache;

import main.lld.cache.exception.NotFoundException;
import main.lld.cache.exception.StorageFullException;

public interface Storage<Key,Value> {
    void add(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws NotFoundException;

    void remove(Key key) throws NotFoundException;
}
