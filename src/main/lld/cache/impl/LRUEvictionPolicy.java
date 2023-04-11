package main.lld.cache.impl;

import main.lld.cache.EvictionPolicy;
import main.lld.cache.algorithms.DoublyLinkedList;
import main.lld.cache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }


    @Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)) {
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            map.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirst();

        if (null == first) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}
