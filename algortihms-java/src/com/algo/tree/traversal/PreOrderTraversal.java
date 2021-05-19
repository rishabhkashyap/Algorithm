package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.Stack;

public class PreOrderTraversal {
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
        preOrder1(node1);
        System.out.println("\n");
        preOrder2(node1);

    }

    public static void preOrder1(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + "\t");
        preOrder1(root.getLeft());
        preOrder1(root.getRight());
    }

    private static void preOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getData() + "\t");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }
}
