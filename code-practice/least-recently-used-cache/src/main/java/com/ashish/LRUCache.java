package com.ashish;

import java.util.*;

/**
 * @author Ashish Sharma
 *         on 10/24/2015.
 */
public class LRUCache<T> {
    private int capacity;
    private Deque<CacheNode<T>> cache;
    private Map<Integer, CacheNode<T>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayDeque<CacheNode<T>>();
        map = new HashMap<Integer, CacheNode<T>>();
    }

    public CacheNode get(Integer pageNumber) {
        CacheNode cacheNode = null;
        if (map.containsKey(pageNumber)) {
            cacheNode = map.get(pageNumber);
            cache.remove(cacheNode);
            cache.addFirst(cacheNode);
        }
        return cacheNode;
    }

    public void set(CacheNode<T> cacheNode) {
        if (!map.containsKey(cacheNode.getPageNumber())) {
            if (map.size() == capacity) {
                CacheNode cacheNodeLast = cache.removeLast();
                map.remove(cacheNodeLast.getPageNumber());
            }
            cache.addFirst(cacheNode);
            map.put(cacheNode.getPageNumber(), cacheNode);
        }
    }
}
