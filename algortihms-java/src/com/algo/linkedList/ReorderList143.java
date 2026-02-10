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
        reorderList1(list.getHead());
        list.display();
    }

    //Clean and easy to understand solution
    private static void reorderList1(Node head) {
        var fast = head;
        var slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //list len is even
        Node rev = null;
        if (fast == null) {
            prev.next = null;
            rev = reverseList(slow);
        } else {
            rev = reverseList(slow.next);
            slow.next = null;
        }
        var current = head;
        while (current != null && rev != null) {
            var temp1 = current.next;
            var temp2 = rev.next;
            current.next = rev;
            rev.next = temp1;
            current = temp1;
            rev = temp2;
        }
    }

    //Smart but confusing solution
    //For even size list like 1->2->3->4->5->6
    //Middle part of the list(3 ->4) will remain same. Following solution therefore just
    //reverse last 2 nodes of list ie 5->6. For any give even size linked list this solution
    //will reverse nodes from n/2 +1 ....n. New head of reverse head will always be made to point to
    //new head.next in merging loop, so it will always point to the  middle nodes(3->4) at the end and gives
    //expected result.

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
