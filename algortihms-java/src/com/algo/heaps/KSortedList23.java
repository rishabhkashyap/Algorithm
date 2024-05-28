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
        ListNode head = new ListNode();
        ListNode tail = head;
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparing(e -> e.node.val));
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] != null) {
                queue.add(new Pair(i, listNodes[i]));
                listNodes[i] = listNodes[i].next;
            } else {
                listNodes[i] = null;
            }
        }
        while (!queue.isEmpty()) {
            var pair = queue.remove();
            tail.next = pair.node;
            tail = tail.next;
            tail.next = null;
            if (listNodes[pair.index] != null) {
                queue.add(new Pair(pair.index, listNodes[pair.index]));
                listNodes[pair.index] = listNodes[pair.index].next;
            }
        }
        return head.next;
    }

    private record Pair(int index, ListNode node) {
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
