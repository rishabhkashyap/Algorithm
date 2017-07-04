package com.cookbook.linkedList;

public class Node {
	public int value;
	public Node next;
	public int getValue() {
		return value;
	}
	public Node(){
		
	}
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
//	public void setValue(int value) {
//		this.value = value;
//	}
//	public Node getNext() {
//		return next;
//	}
//	public void setNext(Node next) {
//		this.next = next;
//	}

}
