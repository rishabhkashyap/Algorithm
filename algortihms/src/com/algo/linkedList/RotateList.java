package com.algo.linkedList;

public class RotateList {

    public static void main(String[] args) {

        List list = new List();
        Node n1 = new Node(60);
        Node n2 = new Node(50);
        Node n3 = new Node(40);
        Node n4 = new Node(30);
        Node n5 = new Node(20);
        Node n6 = new Node(10);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);
        Node head = list.getHead();
        System.out.println("List before rotation");
        list.display();
        list.setHead(rotateList(head, 4));
        System.out.println("List after rotation");
        list.display();

    }

    private static Node rotateList(Node head, int k) {
        Node current = head;
        Node previous=null;
        Node last=head;
        //Convert linked list to circular linked list

        while(last.next!=null){
            last=last.next;
        }
        last.next=current;

        //Rotate list
        for(int i=0;i<k;i++){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        head=current;
        return head;


    }
}
