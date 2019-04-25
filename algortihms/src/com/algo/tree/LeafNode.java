package com.algo.tree;

public class LeafNode {

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node22 = new Node(22);
        Node node23 = new Node(23);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(node22);
        node22.setLeft(node23);
        node23.setRight(new Node(35));
        int leafNodeCount = getLeafNodeCountRecursively(root);
        System.out.println("Total number of leaf nodes in tree = " + leafNodeCount);
    }

    private static int getLeafNodeCountRecursively(Node root) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                return 1;
            }
            int leftCount = getLeafNodeCountRecursively(root.getLeft());
            int rightCount = getLeafNodeCountRecursively(root.getRight());
            return leftCount + rightCount;
        }
        return 0;
    }
}
