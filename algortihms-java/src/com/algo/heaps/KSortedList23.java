package com.algo.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Problem: https://leetcode.com/problems/merge-k-sorted-lists/
public class KSortedList23 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode node3 = new ListNode(2, new ListNode(6, null));
        ListNode[] arr = new ListNode[3];
        arr[0] = node1;
        arr[1] = node2;
        arr[2] = node3;
        ListNode result = mergedList(arr);
        while (result != null) {
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }

    private static ListNode mergedList(ListNode[] listNodes) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (ListNode node : listNodes) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            var node = queue.remove();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
