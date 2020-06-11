package com.algo.linkedList;

public class SplitLinkedList {

    public static void main(String[] args) {
        CircularList circularList1 = new CircularList();
        for (int i = 1; i <= 7; i++) {
            circularList1.insertEnd(i);
        }
        System.out.println("********************Odd size*****************************");
        circularList1.display();
        System.out.println();
        createCircularLinkedList(circularList1.getHead());

        CircularList circularList2 = new CircularList();
        for (int i = 1; i <= 6; i++) {
            circularList2.insertEnd(i);
        }
        System.out.println("\n********************Even size*****************************\n");
        circularList2.display();
        System.out.println();
        createCircularLinkedList(circularList2.getHead());
    }

    private static void createCircularLinkedList(Node head) {
        if (head == null) {
            return;
        }
        Node fastNode = head;
        Node slowNode = head;
        Node previous = null;
        Node lastNode = null;
        do {
            lastNode = fastNode;
            fastNode = fastNode.next.next;
            previous = slowNode;
            slowNode = slowNode.next;

        } while (fastNode != head && fastNode.next != head);
        Node head1 = null;
        Node head2 = null;
        if (fastNode == head) {
            //Even
            head1 = head;
            previous.next = head1;
            head2 = slowNode;
            lastNode.next.next = head2;

        } else {
            //Odd
            head2 = slowNode.next;
            fastNode.next = head2;
            head1 = head;
            slowNode.next = head1;
        }
        displayCircularList(head1);
        displayCircularList(head2);

    }

    private static void displayCircularList(Node head) {
        Node temp = head;
        do {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
