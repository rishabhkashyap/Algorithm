package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.Stack;

public class PostOrderTraversal {
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
        postOrder1(node1);
        System.out.println("\n");
        postOrder2(node1);
    }

    private static void postOrder1(Node root) {
        if (root == null) {
            return;
        }
        postOrder1(root.getLeft());
        postOrder1(root.getRight());
        System.out.print(root.getData() + "\t");
    }

    //Iterative traversal using 2 stacks
    private static void postOrder2(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + "\t");
        }


    }
}
