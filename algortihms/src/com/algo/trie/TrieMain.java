package com.algo.trie;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie = new Trie();
        trie.insert("apple");
		trie.insert("geek");
		trie.insert("geekforgeeks");
		trie.insert("geeky");
		trie.insert("geektrust");

		
		System.out.println(" Apple is available = "+trie.search("apple"));
		System.out.println("Longest common prefix = "+ trie.getLongestPrefix());

	}

}
