package com.cookbook.linkedList;

public class List {
	private Node head;
	private Node headPrev;
	

	public Node getHead() {
		return head;
	}

	public Node getHeadPrev() {
		return headPrev;
	}

	// Adds element at front of linked list
	public void add(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "\t");
			temp = temp.next;
		}

	}
	public void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "\t");
			temp = temp.next;
		}

	}


}
