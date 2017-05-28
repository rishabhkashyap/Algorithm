package com.cookbook.linkedList;

//import javax.sound.sampled.ReverbType;

public class PalindromeList {

	public static void main(String[] args) {
		List list=new List();
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(4);
		Node n6=new Node(3);
		//Node n7=new Node(2);
		//Node n8=new Node(1);
//		
//		Node n1=new Node(1);
//		Node n2=new Node(2);
//		Node n3=new Node(3);
//		Node n4=new Node(4);
//		Node n5=new Node(3);
		//Node n6=new Node(2);
		//Node n7=new Node(1);		
		
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		//list.add(n7);
		//list.add(n8);
		//list.add(n5);
		list.display();
		Node fastPtr=list.getHead();
		Node slowPtr=list.getHead();
		Node middle=null;
		while(fastPtr!=null && fastPtr.next!=null){
			fastPtr=fastPtr.next.next;
			middle=slowPtr;
			slowPtr=slowPtr.next;
		}
		
		//case 1 Even number of nodes
		if(fastPtr==null){
			Node current=slowPtr;
			middle.next=reverseList(current);
			boolean palindromeFlag=isPalindrome(list, middle,middle.next);
			System.out.println();
			list.display();
			System.out.println("\nPalindrome status = "+palindromeFlag);
		}
		//case2 Odd numbers of nodes
		if(fastPtr!=null){
			Node current=slowPtr.next;
			slowPtr.next=reverseList(current);
			boolean palindromeFlag=isPalindrome(list, slowPtr.next,slowPtr.next);
			System.out.println();
			list.display();
			System.out.println("\nPalindrome status = "+palindromeFlag);
			
		}
		
		//System.out.println("middle = "+middle.value);
		
		
		

	}
	
	//Method to reverse liked list
	//Returns head of reversed linked list
	public static Node reverseList(Node current){
		Node next=null;
		Node revHead=null;
		while (current!=null){
			next=current.next;
			current.next=revHead;
			revHead=current;
			current=next;
		}
		return revHead;
	}
	
	//Determines whether string is palindrome or not
	public static boolean isPalindrome(List list,Node middle,Node middleNext){
		Node current=list.getHead();
		while(current!=middle && middleNext!=null){
			if(current.value==middleNext.value){
				current=current.next;
				middleNext=middleNext.next;
			}else{
				return false;
			}
		}
		return true;
	}
		
		
	

}
