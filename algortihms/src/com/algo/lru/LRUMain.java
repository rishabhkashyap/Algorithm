package com.algo.Lru;

public class LRUMain {

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		lru.accessPage(1);
		lru.accessPage(2);
		lru.accessPage(3);
		lru.accessPage(4);
		lru.accessPage(5);
		lru.accessPage(8);
		lru.accessPage(10);

	}

}
