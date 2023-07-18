package com.algo.linkedList;

public class InsertList {
    public static void main(String[] args) {
        List list = new List();
        list.addLast(new Node(2));
        list.addLast(new Node(5));
        list.addLast(new Node(7));
        list.addLast(new Node(10));
        list.addLast(new Node(15));
        System.out.println("Before insertion");
        list.display();
        System.out.println("After insertion");
        Node head = insert(list.getHead(), 9);
        list.display(head);

    }

    private static Node insert(Node head, int key) {
        if (head == null) {
            return new Node(key);
        }
        if (key <= head.getValue()) {
            Node node = new Node(key);
            node.next = head;
            return node;
        }
        Node prev = null;
        Node current = head;
        while (current != null && current.getValue() <= key) {
            prev = current;
            current = current.next;
        }
        Node node = new Node(key);
        node.next = prev.next;
        prev.next = node;
        return head;
    }
}
