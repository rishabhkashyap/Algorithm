package com.algo.trie;

public class Trie {
	private TrieNode root;
	
	public Trie(){
		root=new TrieNode(' ');
	}
	
	public void insert(String word){
		TrieNode current=root;
		if(search(word)){
			return;
			
		}else{
			 String lowerCaseWord=word.toLowerCase();
			for(char ch:lowerCaseWord.toCharArray()){
				TrieNode child=current.getChildren(ch);
				if(child==null){
					TrieNode node=new TrieNode(ch);
					current.addchild(node);
					current=node;
				}else{
					current=child;
				}
			}
			current.setWord(true);
		}
		
	}

	public boolean search(String word) {
		boolean found = false;
		TrieNode current=root;
		 String lowerCaseWord=word.toLowerCase();
			for(char ch:lowerCaseWord.toCharArray()){
				TrieNode node=current.getChildren(ch);
				if(node!=null){
					current=node;
				}else{
					found=false;
					current=node;
					break;
				}
			}
			if(current!=null && current.isWord()){
				found=true;
			}
		return found;
	}
	
	public String getLongestPrefix(){
		StringBuilder sb=new StringBuilder();
		TrieNode current=null;
		if(root.hadOneChild()){
		    current=root.getChildren();
        }else{
		    return "";
        }

		
		while(current.hadOneChild() && !current.isWord()){
			sb.append(current.getCh());
			current=current.getChildren();
		}
		return sb.toString();
		
	
	}

	

}
