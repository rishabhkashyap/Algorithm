package com.algo.tree.bst;

import com.algo.tree.Node;

public class SuccessorNode {

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.setRight(node6);
        root.setLeft(node2);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setRight(node7);
        node6.setLeft(node5);
        System.out.println("Successor of node 5 =  "+inOrderSuccessor(root,node5).getData());
        System.out.println("\nSuccessor of node 4 =  "+inOrderSuccessor(root,root).getData());
    }

    private static Node inOrderSuccessor(Node root, Node node) {
        Node current = root;
        Node successor = null;
        if (root == null) {
            return null;
        }
        if (node.getRight() != null) {
            return findMin(node.getRight());
        }
        while (current != null) {

            if (current.getData() > node.getData()) {
                successor = current;
                current = current.getLeft();
            } else if (current.getData() < node.getData()) {
                current = current.getRight();
            } else {
                break;
            }

        }
        return successor;

    }

    private static Node findMin(Node root) {
        if (root.getLeft() != null) {
            return findMin(root.getLeft());
        }
        return root;
    }
}
