package com.algo.linkedList;

public class ListUtil {

    public static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "\t");
            current = current.next;
        }
    }
}
