package com.ashish;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 *         on 10/24/2015.
 */
public class LRUTest {

    @Test
    public void testLRU() {
        LRUCache<String> lruCache = new LRUCache<String>(5);
        CacheNode<String> cacheNode1 = new CacheNode<String>(1, "1");
        CacheNode<String> cacheNode2 = new CacheNode<String>(2, "2");
        CacheNode<String> cacheNode3 = new CacheNode<String>(3, "3");
        CacheNode<String> cacheNode4 = new CacheNode<String>(4, "4");
        CacheNode<String> cacheNode5 = new CacheNode<String>(5, "5");
        CacheNode<String> cacheNode6 = new CacheNode<String>(6, "6");
        CacheNode<String> cacheNode7 = new CacheNode<String>(7, "7");

        lruCache.set(cacheNode1);
        lruCache.set(cacheNode2);

        System.out.println(lruCache.get(1).getM());

        lruCache.set(cacheNode3);
        lruCache.set(cacheNode4);
        lruCache.set(cacheNode5);
        lruCache.set(cacheNode6);

        if (lruCache.get(4) != null) {
            System.out.println(lruCache.get(4).getM());
        }

        if (lruCache.get(1) != null) {
            System.out.println(lruCache.get(1).getM());
        }
        lruCache.set(cacheNode7);

    }
}
