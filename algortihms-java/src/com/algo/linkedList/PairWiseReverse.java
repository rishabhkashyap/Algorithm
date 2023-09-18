package com.algo.linkedList;

//Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
public class PairWiseReverse {

    public static void main(String[] args) {
        List list = new List();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n6);

        list.display();
        System.out.println();
//        Node revHead = pairWiseReverseNode(list.getHead());
        Node revHead = reverseNodesRecursion(list.getHead());
        list.display(revHead);

    }

    private static Node pairWiseReverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node previous = head;
        Node current = head.next;
        Node newHead = head.next;
        while (true) {
            Node nextNode = current.next;
            current.next = previous;
            if (nextNode == null || nextNode.next == null) {
                previous.next = nextNode;
                break;
            }
            previous.next = nextNode.next;
            previous = nextNode;
            current = previous.next;

        }
        return newHead;

    }

    private static Node reverseNodesRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;
        head.next.next = reverseNodesRecursion(head.next.next);
        return head;
    }

}
