package com.algo.trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	private char ch;
	private boolean isEnd;
	private List<TrieNode> childList;
	private int count;

	public TrieNode(char ch) {
		this.ch = ch;
		this.childList = new ArrayList<>(26);
		this.isEnd = false;
		this.count = 0;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public  void addToChildList(TrieNode node) {
		 childList.add(node);
	}

	public void removeFromChildList(TrieNode node) {
		this.childList.remove(node);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void incrementCount() {
		++count;
	}

	public void decrementCount() {
		--count;
	}

	public TrieNode getChild(char ch) {
		if (childList != null) {
			for (TrieNode child : childList) {
				if (child.ch == ch) {
					return child;
				}
			}
		}
		return null;

	}

}
