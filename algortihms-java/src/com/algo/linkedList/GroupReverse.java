package com.algo.linkedList;

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
        System.out.println("\n List after reverse operation");
        head = reverse(head, 4);
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
        //Once above loop is completed next will be pointing to first node ofremaining linked list
        // use it to recursively reverse group of nodes

        if (next != null) {
            head.next = reverse(next, k);
        }
        return prev;
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
