package com.algo.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TrieNode {
	private static final int SIZE = 26;
	private char ch;
	private boolean isWord;
	private TrieNode[] children;
	private int count;

	public TrieNode(char ch) {
		this.ch = ch;
		children = new TrieNode[26];
		Arrays.stream(children).map(e -> null);
		isWord = false;

	}

	public void addchild(TrieNode node) {
		children[node.ch - 'a'] = node;
	}

	public TrieNode getChildren(char ch) {
		TrieNode node = null;
		int pos = ch - 'a';

		if (children[pos] != null && children[pos].ch == ch) {
			node = children[pos];
		}
		return node;

	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public boolean hadOneChild() {
		long count=Arrays.stream(children)
		      .filter(e->e!=null)
		      .count();
		      
		return (count == 1);
	}

	public char getCh() {
		return ch;
	}
	
	
	public TrieNode getChildren(){
		Optional<TrieNode> child=Arrays.stream(children)
				                       .filter(e->e!=null)
				                       .findFirst();
		return child.get();
		
				                       
				                        
	}
	
	
	

}
