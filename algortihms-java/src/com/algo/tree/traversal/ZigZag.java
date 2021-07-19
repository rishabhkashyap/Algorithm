package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.Stack;

public class ZigZag {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.setRight(node3);
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setRight(new Node(10));
        node4.setLeft(new Node(21));
        performZigzagTraversal(root);
    }

    private static void performZigzagTraversal(Node root) {

        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        }

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            System.out.print(node.getData() + "\t");
            if (leftToRight) {
                insertLeftChild(nextLevel, node);
                insertRightChild(nextLevel, node);

            } else {
                insertRightChild(nextLevel, node);
                insertLeftChild(nextLevel, node);
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;

            }
        }

    }

    private static void insertLeftChild(Stack<Node> stack, Node root) {
        if (root.getLeft() != null) {
            stack.push(root.getLeft());
        }

    }

    private static void insertRightChild(Stack<Node> stack, Node root) {
        if (root.getRight() != null) {
            stack.push(root.getRight());
        }
    }
}
