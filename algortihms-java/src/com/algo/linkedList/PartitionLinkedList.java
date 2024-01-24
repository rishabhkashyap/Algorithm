package com.algo.linkedList;

//Problem: https://leetcode.com/problems/partition-list/description/
public class PartitionLinkedList {

    public static void main(String[] args) {
        List list = new List();
//        list.addLast(new Node(1));
//        list.addLast(new Node(4));
//        list.addLast(new Node(3));
//        list.addLast(new Node(2));
//        list.addLast(new Node(5));
//        list.addLast(new Node(2));
//        list.addLast(new Node(3));


//        list.addLast(new Node(1));
//        list.addLast(new Node(4));
//        list.addLast(new Node(2));
//        list.addLast(new Node(10));
        list.addLast(new Node(10));
        list.addLast(new Node(4));
        list.addLast(new Node(20));
        list.addLast(new Node(10));
        list.addLast(new Node(3));
        list.display();
        Node head = list.getHead();
        head = partitionList2(head, 3);
        display(head);
    }

    private static Node partitionList(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node smallHead = new Node(0);
        Node smallTail = smallHead;
        Node largeHead = new Node(0);
        Node largeTail = largeHead;
        Node equalHead = new Node(0);
        Node equalTail = equalHead;
        Node temp = head;
        while (temp != null) {
            Node node = temp;
            Node next = temp.next;
            node.next = null;
            if (temp.value < k) {
                smallTail = append(smallTail, node);
            } else if (temp.value == k) {
                equalTail = append(equalTail, node);
            } else {
                largeTail = append(largeTail, node);
            }
            temp = next;
        }
        if (smallHead.next == null) {
            equalTail.next = largeHead.next;
            return equalHead.next;
        } else if (equalHead.next == null) {
            smallTail.next = largeHead.next;
            return smallHead.next;
        } else if (largeHead.next == null) {
            smallTail.next = equalHead.next;
            return smallHead.next;
        } else {
            smallTail.next = equalHead.next;
            equalTail.next = largeHead.next;
            return smallHead.next;
        }

    }

    private static Node append(Node tail, Node node) {
        if (tail == null) {
            return null;
        }
        tail.next = node;
        tail = tail.next;
        return tail;

    }

    //Leetcode accepted solution
    private static Node partitionList2(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node leftHead = new Node();
        Node leftTail = leftHead;
        Node rightHead = new Node();
        Node rightTail = rightHead;
        while (head != null) {
            Node temp = head.next;
            if (head.value < k) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head.next = null;
            head = temp;
        }
        leftTail.next = rightHead.next;
        rightHead.next = null;
        return leftHead.next;
    }

    private static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "\t");
            temp = temp.next;
        }
        System.out.println();
    }
}
