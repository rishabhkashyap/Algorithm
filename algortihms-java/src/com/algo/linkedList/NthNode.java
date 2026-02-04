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

    //Stop slow pointer at n -1 th node and move fast pointer to the last node of the list
    //this way we can make n -1 th node's next to point to n + 1 the node and remove nth node
    private static int getNthFromLast(Node head, int n) {
        int count = 1;
        Node current = head;
        while (count < n && current != null) {
            current = current.next;
            ++count;
        }
        if (current == null) {
            return -1;
        }
        Node temp = head;
        while (current != null && current.next != null) {
            temp = temp.next;
            current = current.next;
        }
        return temp.getValue();
    }

    private static Node removeNthNodeEnd(Node head, int n) {
        var fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        var slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
