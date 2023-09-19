package com.algo.linkedList;

//Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
public class GroupReverse {

    public static void main(String[] args) {
        Node head = null;

        for (int i = 10; i >= 1; i--) {
            if (head == null) {
                head = new Node(i);

            } else {
                Node temp = new Node(i);
                temp.next = head;
                head = temp;
            }
        }
        display(head);
        System.out.println("\nList after reverse operation");
        head = reverse(head, 4);
        //head=reverseKGroup(head,4);
        display(head);

    }

    private static Node reverse(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int i = 0;

        while (i < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            ++i;
        }
        //Once above loop is completed next will be pointing to first node of remaining linked list
        // use it to recursively reverse group of nodes

        if (next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

    //Reverse group of size k only when k is less than size
    //Solution to leetcode problem 25
    public static Node reverseKGroup(Node head, int k) {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            ++size;
            curr = curr.next;
        }
        return helper(head, k, size);

    }

    private static Node helper(Node head, int k, int size) {
        if (head == null || head.next == null || size < k) {
            return head;
        }

        Node curr = head;
        Node rev = null;
        Node temp = null;
        int count = 0;
        while (curr != null && count < k) {
            temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
            ++count;
        }
        head.next = helper(temp, k, size - k);
        return rev;
    }


    private static void display(Node head) {
        Node current = head;
        System.out.println();
        while (current != null) {
            System.out.print(current.value + "\t");
            current = current.next;
        }
        System.out.println();

    }
}
