package com.algo.linkedList;

public class MergeList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head1 = null;
        Node head2 = null;
        for (int i = 3; i >= 1; i--) {
            if (head1 == null) {
                head1 = new Node(i);

            } else {
                Node temp = new Node(i);
                temp.next = head1;
                head1 = temp;
            }
        }

        for (int i = 10; i >= 6; i--) {
            if (head2 == null) {
                head2 = new Node(i);
            } else {
                Node temp = new Node(i);
                temp.next = head2;
                head2 = temp;
            }
        }
        display(head1);
        display(head2);
       // Node head = merge(head1, head2);
        Node head=mergeRecursively(head1,head2);
        if (head != null) {
            System.out.println("\nMerged list\n");
            display(head);
        } else {
            System.out.println("bot lists are empty !!\n");
        }


    }

    private static Node merge(Node head1, Node head2) {

        Node current1 = head1;
        Node current2 = head2;
        Node head = new Node(0);
        Node tail = head;

        if (current1 == null) {
            return current2;
        }
        if (current2 == null) {
            return current1;
        }

        while (current1 != null && current2 != null) {
            if (current1.value < current2.value) {
                tail.next = current1;
                current1 = current1.next;
            } else {
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
        }
        if (current1 != null) {
            while (current1 != null) {
                tail.next = current1;
                tail = tail.next;
                current1 = current1.next;
            }
        }
        if (current2 != null) {
            while (current2 != null) {
                tail.next = current2;
                tail = tail.next;
                current2 = current2.next;
            }
        }
        return head.next;


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


    private static Node mergeRecursively(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        Node head = null;
        if (current1 == null) {
            return current2;
        }
        if (current2 == null) {
            return current1;
        }
        if (current1.value < current2.value) {
            head = current1;
            head.next = mergeRecursively(current1.next, current2);
        } else {
            head = current2;
            head.next = mergeRecursively(current1, current2.next);
        }

        return head;
    }

}
