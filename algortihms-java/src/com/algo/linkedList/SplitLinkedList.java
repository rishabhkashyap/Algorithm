package com.algo.linkedList;

public class SplitLinkedList {

    public static void main(String[] args) {
        CircularList circularList = new CircularList();
        for (int i = 1; i <= 7; i++) {
            circularList.insertEnd(i);
        }
        circularList.display();
        createCircularLinkedList(circularList.getHead());
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
            head1 = head;
            previous.next = head1;
            head2 = slowNode;
            lastNode.next.next = head2;

        } else {
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
