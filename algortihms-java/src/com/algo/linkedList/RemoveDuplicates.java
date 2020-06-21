package com.algo.linkedList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List list = new List();
        Random random = new Random();
//        for (int i = 1; i <= 10; i++) {
//            list.addLast(new Node(random.nextInt(5)));
//        }
        list.addLast(new Node(1));
        list.addLast(new Node(1));
        list.addLast(new Node(2));
        list.addLast(new Node(3));
        list.addLast(new Node(4));
        list.addLast(new Node(2));
        list.addLast(new Node(5));
        list.addLast(new Node(6));
        list.addLast(new Node(7));
        list.addLast(new Node(7));
        list.addLast(new Node(8));
        list.display();
        removeDuplicates(list.getHead());
        list.display();
    }

    private static void removeDuplicates(Node head) {
        Node current = head;
        Node previous = null;
        Set<Integer> set = new HashSet<>();
        while (current != null) {

            if (set.contains(current.value)) {
                previous.next = current.next;
            } else {
                set.add(current.value);
                previous = current;
            }

            current = current.next;
        }
    }
}
