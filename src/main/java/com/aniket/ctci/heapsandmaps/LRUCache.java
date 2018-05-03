package com.aniket.ctci.heapsandmaps;

import java.util.HashMap;

public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
     * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
     *
     * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
     *
     *  NOTE: If you are using any global variables, make sure to clear them in the constructor.
     * Example :
     *
     * Input :
     *          capacity = 2
     *          set(1, 10)
     *          set(5, 12)
     *          get(5)        returns 12
     *          get(1)        returns 10
     *          get(10)       returns -1
     *          set(6, 14)    this pushes out key = 5 as LRU is full.
     *          get(5)        returns -1
     */

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1,10);
        lruCache.set(5, 12);
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6, 14);
        System.out.println(lruCache.get(5));
    }

    private int capacity;
    private Node head;
    private Node tail;

    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

    }

    public int get(int key) {

        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        setHead(node);
        return node.val;

    }



    public void set(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            node.val = value;

        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            setHead(newNode);
            if (map.size() > capacity) {
                map.remove(tail.key);
                remove(tail);

            }
        }




    }

    private void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;
        }
    }


    //--------------- Doubly LinkedList Node ------------------

    private class Node{
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}
