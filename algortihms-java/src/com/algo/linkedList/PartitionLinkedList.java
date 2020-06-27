package com.algo.linkedList;


public class PartitionLinkedList {

    public static void main(String[] args) {
        List list = new List();
        list.addLast(new Node(3));
        list.addLast(new Node(7));
        list.addLast(new Node(1));
        list.addLast(new Node(8));
        list.addLast(new Node(4));
        list.addLast(new Node(9));
        list.addLast(new Node(2));
        list.addLast(new Node(21));
        list.addLast(new Node(5));
        list.addLast(new Node(56));
        list.display();
        Node head = list.getHead();
        head = partitionList(head, 4);
        display(head);
    }

    private static Node partitionList(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node smallHead = new Node(0);
        Node smallTail = smallHead;
        Node largeHead = new Node(0);
        Node largeTail = largeHead;
        Node temp = head;
        while (temp != null) {
            Node node = temp;
            Node next = temp.next;
            node.next = null;
            if (temp.value < k) {
                smallTail.next = node;
                smallTail = smallTail.next;
            } else {
                largeTail.next = node;
                largeTail = largeTail.next;
            }
            temp = next;
        }
        smallTail.next = largeHead.next;
        return smallHead.next;

    }

    private static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();
    }
}
