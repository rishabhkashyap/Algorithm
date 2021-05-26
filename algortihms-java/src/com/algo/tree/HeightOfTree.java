package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

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
        int h = getHeight1(root);
        System.out.println("Size of tree = " + h);
        System.out.println("Size of tree = " + getHeight2(root));


    }

    private static int getHeight1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight1(root.getLeft());
        int rightHeight = getHeight1(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;

    }

    private static int getHeight2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
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
