package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 10/04/22 2:35 PM
 */

class LRUCache {

    static class Node {

        Node prev;

        Node next;

        int key;

        int data;

    }


    Node head;

    Node tail;

    int cap;

    int size;

    HashMap<Integer, Node> map = new HashMap<>();


    void addFront(int key, int value) {

        Node node = new Node();

        node.key = key;

        node.data = value;


        if (head == null) {       // no element is there in list

            head = tail = node;

        } else {

            node.next = head;

            head.prev = node;


            head = node;

        }


        size++;

    }


    void remove(Node node) {

        if (head == tail) {    // only element

            head = tail = null;

            size--;

        } else if (node == head) {  //  at head

            head = head.next;

            head.prev = null;

            size--;

        } else if (node == tail) {   // at tail

            removeLast();

        } else {                     // between head and tail

            Node nm1 = node.prev;

            Node np1 = node.next;

            nm1.next = np1;

            np1.prev = nm1;

            size--;

        }

    }


    void removeLast() {

        if (head == tail) {    // only element

            head = tail = null;

            size--;

        } else {

            Node nm1 = tail.prev;    // remove last

            nm1.next = null;

            tail = nm1;


            size--;

        }

    }


    public LRUCache(int capacity) {

        this.cap = capacity;

        this.size = 0;

    }


    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            remove(node);

            addFront(key, node.data);

            map.put(key, head);

            return node.data;

        } else {

            return -1;

        }

    }


    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            remove(node);

        } else if (size == cap) {

            map.remove(tail.key);

            removeLast();

        } else if (size < cap) {


        }


        addFront(key, value);

        map.put(key, head);

    }

}


/**
 * Your LRUCache.java object will be instantiated and called as such:
 * <p>
 * LRUCache.java obj = new LRUCache.java(capacity);
 * <p>
 * int param_1 = obj.get(key);
 * <p>
 * obj.put(key,value);
 */