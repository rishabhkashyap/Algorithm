package com.algo.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RandomPointerCopy {
    public static void main(String[] args) {
        Node head = new Node(5);
        for (int i = 4; i >= 1; i--) {
            head = addLast(head, new Node(i));
        }
        head.next.random = head;
        head.random = head.next.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;
        head.next.next.next.next.random = head.next;
        display(head);
        Node copyHead = copy(head);
        System.out.println("\nCopy of list\n");
        display(copyHead);


    }

    private static Node addLast(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    private static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + "----->\t" + temp.random.data);
            if (temp.next != null) {
                System.out.println("|");
            }

            temp = temp.next;
        }
        System.out.println();

    }

    private static Node copy(Node head) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;

        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    private static final class Node implements Cloneable {
        private Integer data;
        private Node next;
        private Node random;

        public Node(int data, Node next, Node random) {
            this.data = data;
            this.next = next;
            this.random = random;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;

        }

        public Node() {
            this.data = 0;
            this.next = null;
            this.random = null;

        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            if (next == null) {
                return null;
            }
            return new Node(next.data, next.next, next.random);
        }

        public Node getRandom() {
            if (random == null) {

            }
            return random;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Node node = new Node(this.data);
            if (this.random != null) {
                node.random = this.random;
            }
            if (this.next != null) {
                node.next = this.next;
            }
            return node;
        }
    }
}
