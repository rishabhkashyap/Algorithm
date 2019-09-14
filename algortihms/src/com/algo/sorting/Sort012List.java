package com.algo.sorting;

import com.algo.linkedList.List;
import com.algo.linkedList.Node;

public class Sort012List {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 1, 1, 0, 2, 2, 0, 1, 2, 0, 2};
        List list = new List();
        for (int num : arr) {
            Node node = new Node(num);
            list.add(node);
        }
        list.display();
        list.setHead(sortList(list.getHead()));
        list.display();
    }

    private static Node sortList(Node head) {
        Node current = head;
        if (current == null) {
            return null;
        }
        Node zeroes = null;
        Node zeroCurr = new Node();
        zeroes = zeroCurr;
        Node ones = null;
        Node oneCurr = new Node();
        ones = oneCurr;
        Node twoes = null;
        Node twoCurr = new Node();
        twoes = twoCurr;

        while (current != null) {
            if (current.getValue() == 0) {
                zeroCurr.next = current;
                zeroCurr = current;
            } else if (current.getValue() == 1) {
                oneCurr.next = current;
                oneCurr = current;
            } else {
                twoCurr.next = current;
                twoCurr = current;
            }
            current = current.next;
        }
        oneCurr.next=null;
        twoCurr.next=null;
        zeroCurr.next = (oneCurr != null) ? ones.next : twoes.next;
        if (oneCurr != null) {
            oneCurr.next = twoes.next;
        }
        return zeroes.next;
    }
}
