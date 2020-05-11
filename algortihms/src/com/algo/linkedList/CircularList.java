package com.algo.linkedList;

public class CircularList {

    public static void main(String[] args) {
        CList cList = new CList();
        cList.insertFront(1);
        cList.insertFront(2);
        cList.insertFront(3);
        cList.insertFront(4);
        cList.display();
        cList.insertEnd(34);
        cList.insertEnd(38);
        cList.display();
        System.out.println("\nElement deleted from beginning = " + cList.deleteFront());
        System.out.println("\nElement deleted from beginning = " + cList.deleteFront());
        cList.display();
        System.out.println("\nElement deleted from end = " + cList.deleteEnd());
        System.out.println("\nElement deleted from end = " + cList.deleteEnd());
        cList.display();
        System.out.println("\n\n*************************************************************\n");
        CList sortedCList = new CList();
        sortedCList.insertEnd(3);
        sortedCList.insertEnd(5);
        sortedCList.insertEnd(9);
        sortedCList.insertEnd(10);
        sortedCList.display();
        sortedCList.insertInOrder(1);
        sortedCList.display();
        sortedCList.insertInOrder(8);
        sortedCList.display();
        sortedCList.insertInOrder(29);
        sortedCList.display();

        CList oddEvenList = new CList();
        System.out.println("\n\n*************************************************************\n");
        oddEvenList.insertEnd(20);
        oddEvenList.insertEnd(1);
        oddEvenList.insertEnd(2);
        oddEvenList.insertEnd(3);
        oddEvenList.insertEnd(4);
        oddEvenList.insertEnd(5);
        oddEvenList.insertEnd(6);
        oddEvenList.insertEnd(6);
        oddEvenList.insertEnd(8);
        oddEvenList.display();
        oddEvenList.removeEvenNodes();
        oddEvenList.display();


    }


    private static class CList {
        private Node head;

        public void insertFront(int value) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                return;
            }

            Node node = new Node(value);
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            node.next = head;
            head = node;
            temp.next = head;
        }

        public void insertEnd(int value) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                return;
            }
            Node node = new Node(value);
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;

        }

        public int deleteFront() {
            if (head == null) {
                System.out.println("Circular list is empty");
                throw new RuntimeException("Circular list is empty");
            }
            int value = 0;
            if (head.next == head) {
                value = head.value;
                head = null;
                return value;

            }
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            value = head.value;
            temp.next = head.next;
            head = head.next;
            return value;

        }

        public int deleteEnd() {
            if (head == null) {
                System.out.println("Circular list is empty");
                throw new RuntimeException("Circular list is empty");
            }
            if (head.next == head) {
                int value = head.value;
                head = null;
                return value;

            }
            Node temp = head;
            Node previous = head;
            while (temp.next != head) {
                previous = temp;
                temp = temp.next;
            }
            previous.next = head;
            return temp.value;
        }

        public void display() {
            if (head == null) {
                System.out.println("Circular linked list is empty");
                return;
            }
            System.out.println();
            Node temp = head;
            do {
                System.out.print(temp.value + "\t");
                temp = temp.next;
            } while (temp != head);

        }

        public void insertInOrder(int value) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                return;
            }

            if (isNodeSmallerThanHead(head, value)) {
                insertFront(value);
                return;
            }
            Node temp = head;
            while (temp.next != head && temp.next.value < value) {
                temp = temp.next;
            }
            Node node = new Node(value);
            node.next = temp.next;
            temp.next = node;

        }

        private boolean isNodeSmallerThanHead(Node head, int value) {
            return value <= head.value ? true : false;
        }

        public void removeEvenNodes() {
            if (head == null) {
                throw new RuntimeException("Circular list is empty");

            }
            if (head.value % 2 == 0) {
                deleteFront();
            }
            Node temp = head;
            Node previous = head;
            do {
                if (temp.value % 2 == 0) {
                    previous.next = temp.next;
                    temp.next = null;
                    temp = previous.next;
                } else {
                    previous = temp;
                    temp = temp.next;
                }


            } while (temp != head);
        }
    }
}
