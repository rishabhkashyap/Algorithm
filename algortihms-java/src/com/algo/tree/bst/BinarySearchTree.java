package com.algo.tree.bst;

import com.algo.tree.Node;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(20);
        Node node8 = new Node(8);
        Node node22 = new Node(22);
        Node node4 = new Node(4);
        Node node12 = new Node(12);
        Node node10 = new Node(10);
        Node node14 = new Node(14);
        root.setLeft(node8);
        root.setRight(node22);
        node8.setLeft(node4);
        node8.setRight(node12);
        node12.setLeft(node10);
        node12.setRight(node14);
        System.out.println("Tree is binary search tree = " + isBST(root));
    }

    private static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.getData() < maxValue && root.getData() > minValue) {
            return isBST(root.getLeft(), minValue, root.getData())
                    && isBST(root.getRight(), root.getData(), maxValue);
        }
        return false;
    }
}
