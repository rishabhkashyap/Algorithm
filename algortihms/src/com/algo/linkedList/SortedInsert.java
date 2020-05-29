package com.algo.linkedList;

public class SortedInsert {

    public static void main(String[] args) {
        List list = new List();
        list.addLast(new Node(2));
        list.addLast(new Node(5));
        list.addLast(new Node(7));
        list.addLast(new Node(10));
        list.addLast(new Node(15));
        list.addLast(new Node(17));
        Node head = list.getHead();
        display(head);
        System.out.println("\nInserting 6");
        Node node = new Node(6);
        head = insert(head, node);
        display(head);
        System.out.println("\nInserting 1");
        node = new Node(1);
        head = insert(head, node);
        display(head);
        System.out.println("\nInserting 13");
        node = new Node(13);
        head = insert(head, node);
        display(head);
        System.out.println("\nInserting 139");
        node = new Node(139);
        head = insert(head, node);
        display(head);
    }

    private static Node insert(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        }
        if (node.value < head.value) {
            node.next = head;
            head = node;
            return head;
        }
        Node temp = head;
        Node previous = null;
        while (temp != null && temp.value < node.value) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = node;
        node.next = temp;
        return head;

    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();

    }
}
