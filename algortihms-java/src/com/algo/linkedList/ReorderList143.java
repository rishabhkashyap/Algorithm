package com.algo.linkedList;


//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//https://leetcode.com/problems/reorder-list/description/
public class ReorderList143 {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i <= 6; i++) {
            list.addLast(new Node(i));
        }
        list.display();
        reorderList2(list.getHead());
        list.display();
    }

    private static void reorderList1(Node head) {
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

    private static void reorderList2(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node revHead = reverseList(slow.next);
        slow.next = null;
        while (head != null && revHead != null) {
            Node temp1 = head.next;
            Node temp2 = revHead.next;
            head.next = revHead;
            revHead.next = temp1;
            head = temp1;
            revHead = temp2;
        }
    }

    private static Node reverseList(Node head) {
        Node revHead = null;
        while (head != null) {
            Node temp = head.next;
            head.next = revHead;
            revHead = head;
            head = temp;
        }
        return revHead;
    }

}
