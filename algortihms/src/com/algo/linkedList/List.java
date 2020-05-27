package com.algo.linkedList;

public class List {
    private Node head;
    private Node headPrev;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHeadPrev() {
        return headPrev;
    }

    // Adds element at front of linked list
    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

    }

    //Adds node at end of list
    public void addLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();

    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();

    }

    public Node getLastNode() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }
        return count;
    }


}
