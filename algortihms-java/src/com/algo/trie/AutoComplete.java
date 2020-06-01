package com.algo.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AutoComplete {
	private Node root;
	public AutoComplete(){
		root=new Node("");
	}
	
	public void addWords(String[] words){
		for(String str:words){
			insertWordToTrie(str);
		}
	}
	
	private void insertWordToTrie(String word){
		Node current=root;
		for(int i=0;i<word.length();i++){
			if(current.isChildAvailable(word.charAt(i))){
				current=current.getChildren(word.charAt(i));
			}else{
				Node node=new Node(word.substring(0, i+1));
				current.addChildren(word.charAt(i), node);
				current=node;
			}
			if(i==word.length()-1){
				current.setWord(true);
			}
		}
	}
	
	public List<String>get(String prefix){
		List<String>result=new ArrayList<>();
		Node current=root;
		for(int i=0;i<prefix.length();i++){
			if(!current.isChildAvailable(prefix.charAt(i))){
				return result;
			}else{
				current=current.getChildren(prefix.charAt(i));
			}
		}
		getAllWords(current,result);
		return result;
	}
	

	private void getAllWords(Node current, List<String> result) {
		if(current.isWord){
			result.add(current.getPrefix());
		}
		
		Set<Character> keys=current.getChildren().keySet();
		for(Character key:keys){
			Node node= current.getChildren(key);
			getAllWords(node, result);
		}
		
	}

	public static void main(String[] args) {
		AutoComplete trie=new AutoComplete();
		String[] words={
				"a",
				"ab",
				"about",
				"ad",
				"adage",
				"adagio",
				"bar",
				"bard",
				"barn",
				"be",
				"bed",
				"bet",
				"cane",
				"cat",
				"can"
				
		};
		
		trie.addWords(words);
		List<String>result=trie.get("ab");
		if(result.size()>0){
			result.forEach(res->System.out.println(res));
		}else{
			System.out.println("No match found");
		}
		
		

	}
	
	private static class Node{
		private String prefix;
		private Map<Character,Node>children;
		private boolean isWord;
		
		public Node(String prefix){
			this.prefix=prefix;
			isWord=false;
			children=new HashMap<>();
			
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public Node getChildren(Character key) {
			return children.get(key);
		}

		public void addChildren(Character character,Node node) {
			this.children.put(character, node);
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}
		
		public boolean isChildAvailable(Character key){
			return children.containsKey(key);
		}

		public Map<Character, Node> getChildren() {
			return children;
		}
		
		
		
		
	}

}
