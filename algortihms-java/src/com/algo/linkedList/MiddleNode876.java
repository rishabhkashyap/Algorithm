package com.algo.linkedList;

import java.util.stream.IntStream;

//https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleNode876 {
    public static void main(String[] args) {
        List list = new List();
        IntStream.rangeClosed(1,5)
                .forEach(e ->list.addLast(new Node(e)));
        list.display();
        Node node = findMiddleNode(list.getHead());
        System.out.println("Mid node of list = "+node.getValue());
    }
    private static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
