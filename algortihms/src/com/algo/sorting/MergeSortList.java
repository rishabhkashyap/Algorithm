package com.algo.sorting;

import com.algo.linkedList.List;
import com.algo.linkedList.Node;

public class MergeSortList {
    public static void main(String[] args) {
        int[] arr = {8, 2, 9, 6, 27, 3, 20, 32, 40, 4, 5, 7};
        List list = new List();
        for (int num : arr) {
            Node node = new Node(num);
            list.addLast(node);
        }
        list.display();
        Node sortedListHead = sortList(list.getHead());
        list.setHead(sortedListHead);
        list.display();
    }

    private static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //get middle element
        Node middle = getMiddle(head);
        Node middleNext = middle.next;
        middle.next = null;
        Node left = sortList(head);
        Node right = sortList(middleNext);
        Node sortedListHead = merge(left, right);

        return sortedListHead;
    }

    private static Node merge(Node left, Node right) {
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            Node mergeHead = null;
            Node mergeTail = new Node();
            mergeHead = mergeTail;
            while (left != null && right != null) {
                if (left.value < right.value) {
                    mergeTail.next = left;
                    mergeTail = left;
                    left = left.next;
                } else {
                    mergeTail.next = right;
                    mergeTail = right;
                    right = right.next;
                }
            }

            if (left != null) {
                mergeTail.next = left;
                mergeTail = left;
            }
            if (right != null) {
                mergeTail.next = right;
            }
            return mergeHead.next;
        }
    }

    private static Node getMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return previous;
        } else {
            return slow;
        }

    }
}
