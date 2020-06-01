package com.algo.tree;

public class Tree2DLL {

    private Node previous;

    private Node head;

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node6.setRight(node8);
        node7.setRight(node9);

        Tree2DLL tree2DLL = new Tree2DLL();
        tree2DLL.convertToDll(root);
        tree2DLL.printDLL();
        tree2DLL.printDLLReverse();
    }

    public void convertToDll(Node root) {
        if (root == null) {
            return;
        }

        convertToDll(root.getLeft());
        if (previous == null) {
            head = root;
        } else {
            previous.setRight(root);
            root.setLeft(previous);
        }
        previous = root;
        convertToDll(root.getRight());
    }

    public void printDLL() {
        Node current = head;
        System.out.println("Doubly linked list");
        while (current != null) {
            System.out.print(current.getData() + "\t");
            current = current.getRight();
        }
    }

    public void printDLLReverse() {
        Node current = head;
        System.out.println("\n\nDoubly linked list in reverse order");
        while (current.getRight() != null) {
            current = current.getRight();
        }

        while (current != null) {
            System.out.print(current.getData() + "\t");
            current = current.getLeft();
        }
    }
}
