package com.algo.linkedList;

//Problem: https://leetcode.com/problems/add-two-numbers/description/
public class Add2Num2 {
    public static void main(String[] args) {
        List list1 = new List();
        list1.addLast(new Node(2));
        list1.addLast(new Node(4));
        list1.addLast(new Node(3));
        List list2 = new List();
        list2.addLast(new Node(5));
        list2.addLast(new Node(6));
        list2.addLast(new Node(4));
        Node result = addNumbers(list1.getHead(), list2.getHead());
        while (result != null) {
            System.out.print(result.value + "  ");
            result = result.next;
        }

    }

    private static Node addNumbers(Node head1, Node head2) {
        Node head = new Node();
        Node tail = head;
        int carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int value1 = 0;
            int value2 = 0;
            if (head1 != null) {
                value1 = head1.value;
                head1 = head1.next;
            }
            if (head2 != null) {
                value2 = head2.value;
                head2 = head2.next;
            }
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;
        }
        return head.next;

    }
}
