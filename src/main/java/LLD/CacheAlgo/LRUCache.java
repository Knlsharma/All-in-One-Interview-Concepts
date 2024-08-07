package LLD.CacheAlgo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;

    // Node class for the doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly linked list to keep track of the order of usage
    private class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1); // Dummy head
            tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeLast() {
            if (tail.prev == head) return null; // List is empty
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // Move the accessed node to the front
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // Update the value and move to the front
            node.value = value;
            list.remove(node);
            list.addFirst(node);
        } else {
            if (cache.size() == capacity) {
                // Remove the least recently used item
                Node last = list.removeLast();
                if (last != null) {
                    cache.remove(last.key);
                }
            }
            // Add new item
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        // Test case 1
        lruCache.put(1, 1);  // Cache is {1=1}
        lruCache.put(2, 2);  // Cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1, Cache is {2=2, 1=1}

        // Test case 2
        lruCache.put(3, 3);  // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)

        // Test case 3
        lruCache.put(4, 4);  // Evicts key 1, Cache is {3=3, 4=4}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
