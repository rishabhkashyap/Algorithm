package com.algo.tree;

public class Ancestor {
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
        node6.setLeft(node8);
        node7.setRight(node9);
        System.out.println("Ancestors of node9");
        printAncestors(root, node9);
        System.out.println("\nAncestors of node6");
        printAncestors(root, node6);
        System.out.println("\nAncestors of node5");
        printAncestors(root, node5);

    }

    private static boolean printAncestors(Node root, Node node) {
        if (root == null) {
            return false;
        }
        boolean left = printAncestors(root.getLeft(), node);
        boolean right = printAncestors(root.getRight(), node);
        if (left || right) {
            System.out.print(root.getData() + "\t");
            return true;
        }
        if (root == node) {
            return true;
        }
        return false;

    }
}
