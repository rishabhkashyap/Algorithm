package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LeveLOrderTraversal {
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
        levelOrder1(node1);
        System.out.println();
        levelOrder2(node1);
    }

    //Iterative method using queue

    private static void levelOrder1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.getData() + "\t");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    private static void levelOrder2(Node root) {
        int height = getHeight(root);
        for (int i = 0; i <= height; i++) {
            levelOrder2(root, i, 0);
        }

    }

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void levelOrder2(Node root, int level, int current) {
        if (root == null) {
            return;
        }
        if (level == current) {
            System.out.print(root.getData() + "\t");
        }
        levelOrder2(root.getLeft(), level, current + 1);
        levelOrder2(root.getRight(), level, current + 1);
    }


}
