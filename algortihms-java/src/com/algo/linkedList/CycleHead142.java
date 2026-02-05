package com.algo.linkedList;

//Problem: https://leetcode.com/problems/linked-list-cycle/
//Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
public class CycleHead142 {
    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i <= 6; i++) {
            list.addLast(new Node(i));
        }
        //creating cycle;
        Node current = list.getHead();
        while (current.next != null) {
            current = current.next;
        }
        //comment below line to remove cycle
        current.next = list.getHead().getNext().getNext();
        System.out.println(cycleExist(list.getHead()));
        Node node = findCycleHead(list.getHead());
        Integer cycleHeadValue = node != null ? node.getValue() : -1;
        System.out.println("Head of cycle = " + cycleHeadValue);
    }

    private static boolean cycleExist(Node head) {
        Node curr = head;
        Node temp = head;
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            temp = temp.next;
            if (curr == temp) {
                return true;
            }
        }
        return false;
    }

    private static Node findCycleHead(Node head) {
        Node fast = head;
        Node slow = head;
        boolean cycleExist = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleExist = true;
                break;
            }
        }
        if (!cycleExist) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
