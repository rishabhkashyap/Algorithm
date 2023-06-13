package com.algo.tree.bst;

import com.algo.tree.Node;

public class PredecessorNode {

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

        System.out.println("Predecessor of node 5 =  " + getInOrderPredecessor(root, node5).getData());
        System.out.println("Predecessor of node 4 =  " + getInOrderPredecessor(root, root).getData());
        System.out.println("\nPredecessor of node 5 =  " + getInOrderPredecessor2(root, node5).getData());
        System.out.println("Predecessor of node 4 =  " + getInOrderPredecessor2(root, root).getData());

    }

    private static Node getInOrderPredecessor(Node root, Node node) {
        Node current = root;
        Node predecessor = null;
        if (root == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return findMax(node.getLeft());
        }
        while (current != null) {
            if (current.getData() > node.getData()) {
                current = current.getLeft();
            } else if (current.getData() < node.getData()) {
                predecessor = current;
                current = current.getRight();
            } else {
                break;
            }
        }
        return predecessor;
    }

    private static Node getInOrderPredecessor2(Node root, Node node) {
        return helper(root, node, null);
    }

    private static Node helper(Node root, Node node, Node prev) {
        if (root == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return findMax(root.getLeft());
        }
        if (root.getData() > node.getData()) {
            return helper(root.getLeft(), node, prev);
        } else if (root.getData() < node.getData()) {
            return helper(root.getRight(), node, root);
        } else {
            return prev;
        }
    }

    private static Node findMax(Node root) {
        if (root.getRight() != null) {
            return findMax(root.getRight());
        }
        return root;
    }
}
