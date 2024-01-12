package com.algo.linkedList;

//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//https://leetcode.com/problems/reorder-list/solutions/3148599/easily-expalined-step-by-step-code-100-beats-and-0ms-runtime/
public class ReorderList143 {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i <= 5; i++) {
            list.addLast(new Node(i));
        }
        list.display();
        reorderList(list.getHead());
        list.display();
    }

    private static void reorderList(Node head) {
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHead = null;
        if (fast != null) {
            secondHead = slow.next;
            slow.next = null;
        } else {
            prev.next = null;
            secondHead = slow;
        }
        Node revHead = null;
        while (secondHead != null) {
            Node temp = secondHead.next;
            secondHead.next = revHead;
            revHead = secondHead;
            secondHead = temp;
        }
        secondHead = revHead;
        while (head != null) {
            Node temp1 = head.next;
            Node temp2 = null;
            if (secondHead != null) {
                temp2 = secondHead.next;
            }
            head.next = secondHead;
            if (secondHead != null) {
                secondHead.next = temp1;
            }
            head = temp1;
            secondHead = temp2;

        }

    }


    private static class ListNode {
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

}
