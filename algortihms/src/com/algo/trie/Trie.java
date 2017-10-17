package com.algo.trie;

public class Trie {
	private TrieNode root;

	public Trie() {
		this.root=new TrieNode(' ');
	}

	public void insert(String word) {
		if (search(word)) {
			return;
		} else {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				TrieNode child = current.getChild(ch);
				if (child != null) {
					current = child;
				} else {
					TrieNode node=new TrieNode(ch);
					current.addToChildList(node);
					current = node;
				}
			}
			current.setEnd(true);

		}

	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null) {
				return false;
			} else {
				current = current.getChild(ch);
			}
		}
		if (current.isEnd()) {
			return true;
		}
		return false;
	}

}
