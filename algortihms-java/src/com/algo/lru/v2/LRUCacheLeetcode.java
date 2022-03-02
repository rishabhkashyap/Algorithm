package com.algo.lru.v2;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLeetcode {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);


    }

    private static class LRUCache {
        Node head;
        Node tail;
        private Map<Integer, Node> map;
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.size = 0;
            this.capacity = capacity;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                addFirst(node);

            } else {

                Node node = new Node(key, value);
                if (size < capacity) {
                    map.put(key, node);
                    addFirst(node);
                    ++size;
                } else {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                    map.put(key, node);
                    addFirst(node);

                }
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                remove(map.get(key));
                addFirst(map.get(key));
                return map.get(key).value;
            }
            return -1;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

}
