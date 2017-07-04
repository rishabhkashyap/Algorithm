package com.cookbook.linkedList;

public class MergeListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1=new Node();
		Node head2=new Node();
		for(int i=5;i>=1;i--){
			if(head1==null){
				head1.value=i;
				head1.next=null;
				
			}else{
				Node temp=new Node();
				temp.value=i;
				temp.next=head1;
				head1=temp;
			}
		}
		
		for(int i=10;i>=6;i--){
			if(head2==null){
				head2.value=i;
				head2.next=null;
			
			}else{
				Node temp=new Node();
				temp.value=i;
				temp.next=head2;
				head2=temp;
			}
		}
		//display(head2);
		merge(head1,head2);
		System.out.println("-----------------------------------------\n");
		List list=new List();
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.display();
		
		

	}
	public static void merge(Node head1,Node head2){
		
		Node current1=head1;
		Node current2= head2;
		Node head3=null,head3Previous=null;
		while(current1.next!=null&&current2.next!=null){
			Node temp=new Node();
			if(current1.value<current2.value){
				temp.value=current1.value;
				current1=current1.next;
			}else{
				temp.value=current2.value;
				current2=current2.next;
			}
			if(head3==null){
				head3=temp;
				head3Previous=temp;
			}else{
			
				head3Previous.next=temp;
				head3Previous=temp;
			}
		}
		while (current2!=null){
			Node temp=new Node();
			temp.value=current2.value;
			head3Previous.next=temp;
			head3Previous=temp;
			current2=current2.next;
			
		}
		while (current1!=null){
			Node temp=new Node();
			temp.value=current1.value;
			head3Previous.next=temp;
			head3Previous=temp;
			current1=current1.next;
			
		}
		display(head3);
		
	}
	public static void display(Node head){
		while (head.next!=null){
			System.out.print(head.value+"\t");
			head=head.next;
		}
		
	}

}
