package com.algo.linkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Intersection {
    public static void main(String[] args) {
        List list1 = new List();
        list1.addLast(new Node(1));
        list1.addLast(new Node(3));
        list1.addLast(new Node(5));

        List list2 = new List();
        list2.addLast(new Node(2));
        list2.addLast(new Node(4));
        list2.addLast(new Node(6));
        list2.addLast(new Node(8));
        list2.addLast(new Node(18));
        Node list1End = list1.getLastNode();
        Node list2End = list2.getLastNode();
        List commonList = new List();
        commonList.addLast(new Node(10));
        commonList.addLast(new Node(15));
        commonList.addLast(new Node(20));
        commonList.addLast(new Node(25));
        commonList.addLast(new Node(30));
        list1End.next = commonList.getHead();
        list2End.next = commonList.getHead();
        list1.display();
        list2.display();
        System.out.println("Intersection of linked lists = " + findIntersection1(list1, list2).value);
        System.out.println("Intersection of linked lists = " + findIntersection2(list1, list2).value);
        System.out.println("Intersection of linked lists = " + findIntersection3(list1, list2).value);
    }

    private static Node findIntersection1(List list1, List list2) {
        int list1Length = list1.size();
        int list2Length = list2.size();
        Node head1 = null;
        Node head2 = null;
        if (list1Length > list2Length) {
            head1 = moveForward(list1, list1Length - list2Length);
            head2 = list2.getHead();
        } else if (list2Length > list1Length) {
            head1 = list1.getHead();
            head2 = moveForward(list2, list2Length - list1Length);
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    private static Node moveForward(List list, int difference) {
        int count = 0;
        Node temp = list.getHead();
        while (count < difference) {
            temp = temp.next;
            ++count;
        }
        return temp;
    }

    private static Node findIntersection2(List list1, List list2) {
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();
        Set<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    private static Node findIntersection3(List list1, List list2) {
        Node head1 = list1.getHead();
        Node head2 = list2.getHead();
        Stack<Node> stack1 = createStack(head1);
        Stack<Node> stack2 = createStack(head2);

        Node lastEqual = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                lastEqual = stack1.peek();
            }
            stack1.pop();
            stack2.pop();
        }
        return lastEqual;

    }

    private static Stack<Node> createStack(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        return stack;
    }
}
