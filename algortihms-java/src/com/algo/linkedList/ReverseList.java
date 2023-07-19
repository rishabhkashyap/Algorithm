package com.algo.linkedList;

public class ReverseList {

	public static void main(String[] args) {
		List list = new List();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);

		list.display();
		//Node revHead=reverseIteratively(n6);
		Node revHead=reverse(n6);
		System.out.println();
		list.display(revHead);


	}
	
	private static Node reverse(Node head){
		if(head==null||head.next==null){
			return head;
		}
		Node remainingNode=reverse(head.next);
		head.next.next=head;
		head.next=null;
		return remainingNode;
	}
	private static Node reverseIteratively(Node head){
		if(head==null||head.next==null){
			return head;
		}
		Node reverseHead=null;
		while(head!=null){
			Node nextNode=head.next;
			head.next=reverseHead;
			reverseHead=head;
			head=nextNode;
		}
		return reverseHead;
	}
	

}
