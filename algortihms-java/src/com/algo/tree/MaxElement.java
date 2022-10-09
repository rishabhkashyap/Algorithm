package com.algo.tree;

public class MaxElement {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        System.out.println("Max element = " + max(node1));
    }

    private static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = max(root.getLeft());
        int rightMax = max(root.getRight());
        return Math.max(Math.max(leftMax, rightMax), root.getData());
    }
}
