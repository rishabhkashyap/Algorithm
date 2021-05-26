package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLeveLOrderTraversal {
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
        reverseLevelOrder1(node1);
        System.out.println();
        reverseLevelOrder2(node1);

    }

    private static void reverseLevelOrder1(Node root) {
        int height = findHeight(root);
        for (int i = height-1; i >= 0; i--) {
            printLevel(root, i);
        }
    }

    private static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.getLeft());
        int right = findHeight(root.getRight());
        return Math.max(left, right) + 1;
    }

    private static void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.getData() + "\t");
        }
        printLevel(root.getLeft(), level - 1);
        printLevel(root.getRight(), level - 1);
    }

    private static void reverseLevelOrder2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            stack.push(node);
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData() + "\t");
        }
    }
}
