package com.algo.trie;

public class TrieMain {

	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("hello");
		trie.insert("world");
		trie.insert("spock");
		trie.insert("kirk");
		
		System.out.println("Is Kirk avaialble = "+trie.search("world1"));
		

	}

}
