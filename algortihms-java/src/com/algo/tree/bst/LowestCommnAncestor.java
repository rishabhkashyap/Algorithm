package com.algo.tree.bst;

import com.algo.tree.Node;

public class LowestCommnAncestor {
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
        System.out.println("Lowest common ancestor = " + lca(root, node10, node22).getData());
    }

    private static Node lca(Node root, Node node1, Node node2) {
        if (root == null) {
            return null;
        }
        if (node1 == null || node2 == null) {
            return null;
        }
        if (root.getData() > node1.getData() && root.getData() > node2.getData()) {
            return lca(root.getLeft(), node1, node2);
        }
        if (root.getData() < node1.getData() && root.getData() < node2.getData()) {
            return lca(root.getRight(), node1, node2);
        }
        return root;
    }
}
