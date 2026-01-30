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

        private final Map<Integer, Node> map;

        private final Integer capacity;

        private final Node head;

        private final Node tail;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                var node = map.get(key);
                node.value = value;
                remove(node);
                addFirst(node);
            } else {
                if (map.size() >= capacity) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                var node = new Node(key, value);
                map.put(key, node);
                addFirst(node);
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                var node = map.get(key);
                remove(node);
                addFirst(node);
                return node.value;
            }
            return -1;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }


        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
        }
    }

}
