package com.algo.linkedList;

//Problem: https://leetcode.com/problems/reverse-linked-list-ii/description/

public class ReverseList92 {
    public static void main(String[] args) {
        var head = new ListNode(1);
        var temp = head;
        for (var i = 2; i <= 5; i++) {
            var node = new ListNode(i);
            temp.next = node;
            temp = node;
        }
        var left = 2;
        var right = 4;
        var result = reverseList(head, left, right);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
        result = reverseList2(head, left, right);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode reverseList(ListNode head, int left, int right) {
        //Using dummy node allows to handle edge case where left = 1 ie left is pointing
        //to head of linked list.
        var dummy = new ListNode(0);
        dummy.next = head;
        var prev = dummy;
        for (var i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        var curr = prev.next;
        ListNode forward;
        for (var i = 0; i < right - left; i++) {
            forward = curr.next;
            curr.next = forward.next;
            forward.next = prev.next;
            prev.next = forward;
        }
        return dummy.next;
    }

    //Preferred solution.
    //reverse right - left +1 nodes and then attach it to original list
    private static ListNode reverseList2(ListNode head, int left, int right) {
        //Using dummy node allows to handle edge case where left = 1 ie left is pointing
        //to head of linked list.
        var dummy = new ListNode(0);
        dummy.next = head;
        var prev = dummy;
        for (var i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        var curr = prev.next;
        ListNode temp = null;
        ListNode reverseHead = null;
        for (var i = 0; i < right - left + 1; i++) {
            temp = curr.next;
            curr.next = reverseHead;
            reverseHead = curr;
            curr = temp;
        }
        prev.next.next = temp;
        prev.next = reverseHead;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
