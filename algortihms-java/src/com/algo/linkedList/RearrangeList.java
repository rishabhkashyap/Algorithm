package com.algo.linkedList;

import java.util.Stack;

//L1->L2->L3->L4->L5
//L1->L5->L2->L4->L3

public class RearrangeList {
    public static void main(String[] args) {
        List list1 = new List();
        for (int i = 1; i <= 6; i++) {
            list1.addLast(new Node(i));
        }
        Node head1 = list1.getHead();
        System.out.println("****************Approach1**************************");
        display(head1);
        head1 = rearrangeList1(head1);
        display(head1);
        System.out.println("****************************************************\n");

        List list2 = new List();
        for (int i = 1; i <= 5; i++) {
            list2.addLast(new Node(i));
        }
        Node head2 = list2.getHead();
        System.out.println("****************Approach2**************************");
        display(head2);
        head2 = rearrangeList2(head2);
        display(head2);


    }

    private static Node rearrangeList1(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = getStack(head);
        Node temp = head;
        Node current = new Node();
        Node tail = current;
        boolean pickFromStack = false;
        int count = stack.size();
        int i = 0;
        while (i < count) {
            Node node = null;
            if (pickFromStack) {
                node = stack.pop();
                node.next = null;
                tail.next = node;
            } else {
                node = temp;
                tail.next = node;
                temp = temp.next;
                node.next = null;
            }
            pickFromStack = !pickFromStack;
            tail = tail.next;
            ++i;
        }

        return current.next;
    }

    private static Stack<Node> getStack(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        return stack;
    }

    private static Node rearrangeList2(Node head) {
        if (head == null) {
            return null;
        }
        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        boolean pickFromFirstList = true;
        Node current = new Node();
        Node tail = current;
        Node temp1 = head;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            Node node = null;
            if (pickFromFirstList) {
                node = temp1;
                temp1 = temp1.next;
                node.next = null;
                tail.next = node;
            } else {
                node = temp2;
                temp2 = temp2.next;
                node.next = null;
                tail.next = node;
            }
            tail = tail.next;
            pickFromFirstList = !pickFromFirstList;
        }
        if (temp1 != null) {
            tail.next = temp1;
        }
        return current.next;

    }

    private static Node findMid(Node head) {
        Node fastNode = head;
        Node slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node revHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return revHead;
    }

    private static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "\t");
            current = current.next;
        }
        System.out.println();

    }
}
