package LLD.CacheAlgo;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 03/08/24, Saturday
 **/
public class LFUCache {
    private final int capacity;
    private int size;
    private final Map<Integer, CacheNode> cache; // key -> CacheNode
    private final TreeMap<Integer, LinkedList<Integer>> freqMap; // frequency -> keys with that frequency

    // CacheNode to store key, value, and frequency
    private static class CacheNode {
        int key;
        int value;
        int freq;

        CacheNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    // Constructor
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.freqMap = new TreeMap<>();
    }

    // Update frequency of the key
    private void updateFrequency(CacheNode node) {
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node.key);

        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedList<>()).add(node.key);
    }

    // Get the value of the key
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        CacheNode node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (size >= capacity) {
                evictLFU();
            }
            CacheNode newNode = new CacheNode(key, value, 1);
            cache.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedList<>()).add(key);
            size++;
        }
    }

    // Evict the least frequently used item
    private void evictLFU() {
        Map.Entry<Integer, LinkedList<Integer>> entry = freqMap.firstEntry();
        LinkedList<Integer> keys = entry.getValue();
        int lfuKey = keys.removeFirst();

        if (keys.isEmpty()) {
            freqMap.remove(entry.getKey());
        }

        cache.remove(lfuKey);
        size--;
    }

    // Main method to test the LFUCache implementation
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);  // Cache is {1=1}
        cache.put(2, 2);  // Cache is {1=1, 2=2}
        System.out.println(cache.get(1)); // returns 1, Cache is {2=2, 1=1}

        cache.put(3, 3);  // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 4);  // Evicts key 1, Cache is {3=3, 4=4}
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

}
