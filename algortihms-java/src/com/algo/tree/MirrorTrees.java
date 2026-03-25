package com.algo.tree;

//Problem: https://leetcode.com/problems/invert-binary-tree/description/

public class MirrorTrees {

    static void main() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        System.out.println("Original Tree");
        TreeUtil.preOrder(root);
        root = flipTree(root);
        System.out.println("\nFlipped tree");
        TreeUtil.preOrder(root);
    }

    private static Node flipTree(Node root) {
        if (root == null) {
            return null;
        }
        flipTree(root.getLeft());
        flipTree(root.getRight());
        var temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);
        return root;
    }


}
