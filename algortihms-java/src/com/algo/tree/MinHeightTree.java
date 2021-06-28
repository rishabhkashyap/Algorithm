package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinHeightTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(new Node(22));
//        Node root = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        root.setLeft(node2);
//        root.setRight(node3);
//        node2.setLeft(node4);
//        node2.setRight(node5);
        System.out.println("Minimum height of tree = " + getMinHeight1(root));
        System.out.println("Minimum height of tree = " + getMinHeight2(root));
    }

    private static int getMinHeight1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        //Null check is added because null node will return 0 and when min is taken
        // id doesn't give the expected result, so avoid null child
        if (root.getLeft() == null) {
            return getMinHeight1(root.getRight()) + 1;
        }
        if (root.getRight() == null) {
            return getMinHeight1(root.getLeft()) + 1;
        }
        return Math.min(getMinHeight2(root.getLeft()), getMinHeight1(root.getRight())) + 1;
    }

    private static int getMinHeight2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                if (node.getLeft() == null && node.getRight() == null) {
                    return height + 1;
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            } else {
                ++height;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return height;
    }
}