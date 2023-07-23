package com.algo.linkedList;

import java.util.stream.IntStream;

//https://leetcode.com/problems/odd-even-linked-list/description/
public class OddEvenList328 {
    public static void main(String[] args) {
        List list = new List();
        IntStream.rangeClosed(1, 6)
                .forEach(e -> list.addLast(new Node(e)));
        list.display();
        System.out.println();
        Node head = splitList(list.getHead());
        list.display(head);

    }

    public static Node splitList(Node head) {
        if (head == null) {
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        // `even != null` rules out the list of only 1 node
        // `even.next != null` rules out the list of only 2 nodes
        while (even != null && even.next != null) {
            //Put odd to odd list
            odd.next = odd.next.next;
            //Put even to even list
            even.next = even.next.next;
            //Move odd and even pointers to next odd and even node
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
