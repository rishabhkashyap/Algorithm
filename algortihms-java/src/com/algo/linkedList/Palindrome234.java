package com.algo.linkedList;


import java.util.Stack;
//Problem: https://leetcode.com/problems/palindrome-linked-list/description/

public class Palindrome234 {
    public static void main(String[] args) {
        ListNode head = null;
        for (int i = 1; i <= 5; i++) {
            var node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }
        System.out.println(isPalindrome1(head));
    }

    //1->6->6->6-1
    //since its odd length list slow pointer will point to middle "6"
    //after reversing seconde half linked list will look like this
    //1->6 1->6->6->null
    //   |_______|^
    // that's why below logic works for the odd len list
    private static boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var secHead = reverse(slow);
        while (secHead != null) {
            if (head.val != secHead.val) {
                return false;
            }
            secHead = secHead.next;
            head = head.next;
        }
        return true;

    }

    private static ListNode reverse(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            var next = head.next;
            head.next = rev;
            rev = head;
            head = next;
        }
        return rev;
    }


    public boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        var current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        current = head;
        while (!stack.isEmpty()) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }
        return true;
    }


    public static class ListNode {
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
