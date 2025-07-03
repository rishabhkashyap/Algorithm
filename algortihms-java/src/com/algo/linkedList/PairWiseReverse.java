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
        var revHead = swapNodes(list.getHead());
        // Node revHead = reverseNodesRecursion(list.getHead());
        list.display(revHead);
    }

    private static Node swapNodes(Node head) {
        var dummy = new Node(0);
        dummy.next = head;
        var prev = dummy;
        var curr = head;
        while (curr != null && curr.next != null) {
            var temp = curr.next.next;
            var second = curr.next;
            //swap nodes
            second.next = curr;
            curr.next = temp;
            prev.next = second;
            prev = curr;
            curr = temp;
        }
        return dummy.next;
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
