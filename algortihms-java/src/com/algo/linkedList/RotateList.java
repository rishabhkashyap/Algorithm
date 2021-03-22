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
        System.out.println("Rotate list front to back");
        list.display();
        list.setHead(rotateListFrontToback(head, 2));
        list.display();
        System.out.println("\nRotate list back to front");
        List list2 = new List();
        for (int i = 1; i <= 5; i++) {
            list2.addLast(new Node(i));
        }
        list2.display();
        list2.setHead(rotateListBackToFront1(list2.getHead(), 2));
        list2.display();
        List list3 = new List();
        for (int i = 1; i <= 5; i++) {
            list3.addLast(new Node(i));
        }
        System.out.println("\nRotate list back to front");
        list3.display();
        list3.setHead(rotateListBackToFront2(list3.getHead(), 11));
        list3.display();


    }

    //Move from front to back
    //10	20	30	40	50	60	=> 30	40	50	60	10	20
    // |_____|________________|
    //       |________________|
    private static Node rotateListFrontToback(Node head, int k) {
        Node current = head;
        Node previous = null;
        Node last = head;
        //Convert linked list to circular linked list

        while (last.next != null) {
            last = last.next;
        }
        last.next = current;

        //Rotate list
        for (int i = 0; i < k; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        head = current;
        return head;


    }

    //Moves elements from back to front
    private static Node rotateListBackToFront1(Node head, int k) {
        if (head == null) {
            return null;
        }
        int count = 1;
        Node tail = head;
        while (tail.next != null) {
            ++count;
            tail = tail.next;
        }
        if (k > count) {
            k = k % count;

        }
        Node previous = null;
        Node newHead = head;
        int i = 0;
        while (i < count - k) {
            previous = newHead;
            newHead = newHead.next;
            ++i;
        }
        previous.next = null;
        tail.next = head;
        return newHead;

    }

    //Moves elements from back to front
    private static Node rotateListBackToFront2(Node head, int k) {

        Node current = head;
        Node previous = null;
        Node last = head;
        int count = 1;
        //Convert linked list to circular linked list
        while (last.next != null) {
            last = last.next;
            ++count;
        }
        last.next = current;
        if (k > count) {
            k = k % count;
        }

        //Rotate list
        for (int i = 0; i < count - k; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        head = current;
        return head;


    }


}
