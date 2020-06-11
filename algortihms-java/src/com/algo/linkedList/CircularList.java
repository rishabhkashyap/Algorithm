package com.algo.linkedList;

public class CircularList {
    private Node head;

    public void insertFront(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            return;
        }

        Node node = new Node(value);
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        node.next = head;
        head = node;
        temp.next = head;
    }

    public void insertEnd(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;

    }

    public int deleteFront() {
        if (head == null) {
            System.out.println("Circular list is empty");
            throw new RuntimeException("Circular list is empty");
        }
        int value = 0;
        if (head.next == head) {
            value = head.value;
            head = null;
            return value;

        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        value = head.value;
        temp.next = head.next;
        head = head.next;
        return value;

    }

    public int deleteEnd() {
        if (head == null) {
            System.out.println("Circular list is empty");
            throw new RuntimeException("Circular list is empty");
        }
        if (head.next == head) {
            int value = head.value;
            head = null;
            return value;

        }
        Node temp = head;
        Node previous = head;
        while (temp.next != head) {
            previous = temp;
            temp = temp.next;
        }
        previous.next = head;
        return temp.value;
    }

    public void display() {
        if (head == null) {
            System.out.println("Circular linked list is empty");
            return;
        }
        System.out.println();
        Node temp = head;
        do {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        } while (temp != head);

    }

    public void insertInOrder(int value) {
        if (head == null) {
            head = new Node(value);
            head.next = head;
            return;
        }

        if (isNodeSmallerThanHead(head, value)) {
            insertFront(value);
            return;
        }
        Node temp = head;
        while (temp.next != head && temp.next.value < value) {
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;

    }

    private boolean isNodeSmallerThanHead(Node head, int value) {
        return value <= head.value ? true : false;
    }

    public void removeEvenNodes() {
        if (head == null) {
            throw new RuntimeException("Circular list is empty");

        }
        if (head.value % 2 == 0) {
            deleteFront();
        }
        Node temp = head;
        Node previous = head;
        do {
            if (temp.value % 2 == 0) {
                previous.next = temp.next;
                temp.next = null;
                temp = previous.next;
            } else {
                previous = temp;
                temp = temp.next;
            }


        } while (temp != head);
    }

    public Node getHead() {
        return head;
    }
}
