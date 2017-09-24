package com.algo.linkedList;

public class SumLinkedList {

	public static void main(String[] args) {
		List list1 = new List();
		List list2 = new List();
		Node node2 = new Node(9);
		Node node3 = new Node(9);
		Node node4 = new Node(9);
		Node node5 = new Node(9);
		Node node6 = new Node(9);
		// Adding nodes in list1
		list1.add(node2);
		list1.addLast(node4);
		list1.addLast(node3);
		System.out.print("List 1 =  ");
		list1.display();
		list2.add(node5);
		list2.addLast(node6);
		list2.addLast(new Node(4));
		System.out.print("\nList 2 =  ");
		list2.display();

		Node result = getSumItertive(list1, list2);
		List listSum=new List();
		listSum.add(result);
		System.out.print("\n Sum = ");
		listSum.display();

	}

	private static Node getSumItertive(List list1, List list2) {
		Node result = null;		
		Node temp1 = list1.getHead();
		Node temp2 = list2.getHead();
		int carry = 0;
		while (temp1 != null && temp2 != null) {
			int sum = temp1.getValue() + temp2.getValue() + carry;
			Node node = new Node(sum % 10);
			result=add(result,node);
			carry = sum / 10;			
			temp1 = temp1.next;
			temp2 = temp2.next;

		}
		if (temp1 != null) {
			int sum = temp1.getValue() + carry;
			result.next = new Node(sum % 10);
			Node node = new Node(sum % 10);
			result=add(result,node);
			temp1 = temp1.next;
			carry = sum / 10;
		}
		if (temp2 != null) {
			int sum = temp2.getValue() + carry;
			
			Node node = new Node(sum % 10);
			if(result==null){
				result=node;
			}else{
				node.next=result;
				result=node;
			}			
			temp1 = temp2.next;
			carry = sum / 10;
		}
		if(carry>0){
			Node node=new Node(carry);
			node.next=result;
			result=node;
		}

		return result;
	}
	
	private  static Node add(Node result,Node node) {
		if(result==null){
			result=node;
		}else{
			node.next=result;
			result=node;
		}
		return  result;

	}


}
