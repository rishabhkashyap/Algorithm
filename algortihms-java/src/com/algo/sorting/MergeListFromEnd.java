package com.algo.sorting;

import com.algo.linkedList.List;
import com.algo.linkedList.ListUtil;
import com.algo.linkedList.Node;


public class MergeListFromEnd {
    public static void main(String[] args) {
        List list1 = new List();
        list1.addLast(new Node(1));
        list1.addLast(new Node(3));
        list1.addLast(new Node(5));

        List list2 = new List();
        list2.addLast(new Node(2));
        list2.addLast(new Node(6));
        list2.addLast(new Node(7));
        list2.addLast(new Node(10));
        ListUtil.display(list1.getHead());
        System.out.println();
        ListUtil.display(list2.getHead());
        Node head = mergeFromLast(list1.getHead(), list2.getHead());
        System.out.println("\n\nResult after merging list");
        ListUtil.display(head);

    }

    private static Node mergeFromLast(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return reverseList(head2);
        }
        if (head2 == null) {
            return reverseList(head1);
        }
        Node head = null;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                Node temp = head1.getNext();
                head = addNode(head, head1);
                head1 = temp;

            } else {
                Node temp = head2.getNext();
                head = addNode(head, head2);
                head2 = temp;
            }
        }
        while (head1 != null) {
            Node temp = head1.getNext();
            head = addNode(head, head1);
            head1 = temp;
        }
        while (head2 != null) {
            Node temp = head2.getNext();
            head = addNode(head, head2);
            head2 = temp;
        }
        return head;
    }


    private static Node reverseList(Node head) {
        Node revHead = null;
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = revHead;
            revHead = current;
            current = temp;
        }
        return revHead;
    }

    private static Node addNode(Node head, Node node) {
        node.setNext(head);
        head = node;
        return head;
    }
}
