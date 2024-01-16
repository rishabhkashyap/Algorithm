package com.algo.linkedList;

//Problem: https://leetcode.com/problems/rotate-list/description/
public class RotateList61 {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i <= 5; i++) {
            list.addLast(new Node(i));
        }
        int k = 12;
        Node head = rotateList(list.getHead(), k);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "  ");
            temp = temp.next;
        }
    }

    private static Node rotateList(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        int nodeCount = size(head);
        k %= nodeCount;
        if (k == 0) {
            return head;
        }
        Node slowPtr = null;
        Node fastPtr = null;
        Node curr = head;
        for (int i = 0; i < k; i++) {
            fastPtr = curr;
            curr = curr.next;
        }
        while (fastPtr.next != null) {
            if (slowPtr == null) {
                slowPtr = head;
            } else {
                slowPtr = slowPtr.next;
            }
            fastPtr = fastPtr.next;
        }
        Node prev = slowPtr;
        slowPtr = slowPtr.next;
        prev.next = null;
        fastPtr.next = head;
        return slowPtr;

    }

    private static int size(Node head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.next;
        }
        return count;
    }
}
