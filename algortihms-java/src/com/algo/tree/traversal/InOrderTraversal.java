package com.algo.tree.traversal;


import com.algo.tree.Node;

import java.util.Stack;

public class InOrderTraversal {
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
//        printInOrder1(node1);
        printInOrder2(node1);
    }

    private static void printInOrder1(Node root) {
        if (root == null) {
            return;
        }
        printInOrder1(root.getLeft());
        System.out.print(root.getData() + "\t");
        printInOrder1(root.getRight());
    }

    private static void printInOrder2(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root node cannot be null");
        }
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (!stack.isEmpty()) {
                Node current = stack.pop();
                System.out.print(current.getData() + "\t");
                root = current.getRight();
            } else {
                break;
            }
        }
    }


}
