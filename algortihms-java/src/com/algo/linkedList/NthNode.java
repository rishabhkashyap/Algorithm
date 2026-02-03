package com.algo.linkedList;

//Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class NthNode {
    public static void main(String[] args) {
        List list = new List();
        int n = 3;
        for (int i = 1; i <= 5; i++) {
            list.addLast(new Node(i));
        }
        list.display();
        System.out.println(n + " th node from end = " + getNthFromLast(list.getHead(), n) + "\n");
        Node node = removeNthNodeEnd(list.getHead(), n);
        list.display(node);
    }

    private static int getNthFromLast(Node head, int n) {
        int count = 1;
        Node current = head;
        while (count < n) {
            current = current.next;
            ++count;
            if (current == null) {
                return -1;
            }
        }
        Node temp = head;
        while (current != null &&current.next != null) {
            temp = temp.next;
            current = current.next;
        }
        return temp.getValue();
    }

    private static Node removeNthNodeEnd(Node head, int n) {
        int count = 0;
        Node temp = head;
        Node current = head;
        //Stop temp at n-1th node
        while (count < n) {
            current = current.getNext();
            ++count;
            if (current == null) {
                return head.next;
            }
        }
        while (current != null && current.getNext() != null) {
            current = current.next;
            temp = temp.next;
        }
        assert temp != null;
        temp.next = temp.next.next;
        return head;
    }

}
