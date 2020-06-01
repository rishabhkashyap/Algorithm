package com.algo.sorting;

import com.algo.linkedList.Node;

public class SortReverse {
    public static void main(String[] args) {
        Node head1 = null;
        Node head2 = null;
        for (int i = 8; i >= 1; i -= 2) {
            if (head1 == null) {
                head1 = new Node(i);

            } else {
                Node temp = new Node(i);
                temp.next = head1;
                head1 = temp;
            }
        }


        for (int i = 15; i >= 6; i -= 2) {
            if (head2 == null) {
                head2 = new Node(i);
            } else {
                Node temp = new Node(i);
                temp.next = head2;
                head2 = temp;
            }
        }
        System.out.println("Orignal lists");
        display(head1);
        display(head2);
        Node head = mergeList(head1, head2);
        System.out.println("\n\nSorted list");
        display(head);
        //display(head2);
    }

    private static Node mergeList(Node head1, Node head2) {
        Node head = null;
        Node next = null;
        if (head1 != null && head2 != null) {
            while (head1 != null && head2 != null) {
                if (head1.getValue() < head2.getValue()) {
                    next = head1.next;
                    head = reverse(head1, head);
                    head1 = next;

                } else {
                    next = head2.next;
                    head = reverse(head2, head);
                    head2 = next;
                }
            }
        }

        if (head1 != null) {
            while (head1 != null) {
                next = head1.next;
                head = reverse(head1, head);
                head1 = next;
            }
        }

        if (head2 != null) {
            while (head2 != null) {
                next = head2.next;
                head = reverse(head2, head);
                head2 = next;
            }
        }

        return head;
    }


    private static Node reverse(Node node, Node head) {
        node.next = head;
        head = node;
        return head;
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
