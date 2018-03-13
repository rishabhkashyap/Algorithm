package com.algo.trie;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("apple");
		trie.insert("Qwerty");
		trie.insert("garbage");
		
		System.out.println(" Apple is available = "+trie.search("apple"));

	}

}
