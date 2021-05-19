package com.algo.tree.traversal;

import com.algo.tree.Node;

public class ContainElement {
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
        int element = 5;
        System.out.println(element + " is present in tree = " + contains(node1, element));
    }

    private static boolean contains(Node root, int element) {
        if (root == null) {
            return false;
        }
        if (root.getData() == element) {
            return true;
        }
        return contains(root.getLeft(), element) || contains(root.getRight(), element);

    }
}
