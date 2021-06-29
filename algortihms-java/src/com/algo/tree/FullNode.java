package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FullNode {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node7.setLeft(node8);
        node7.setRight(node9);
        System.out.println("Number of full nodes = " + countFullNodes1(root));
        System.out.println("Number of full nodes = " + countFullNodes2(root));
    }

    private static int countFullNodes1(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.getLeft() != null && root.getRight() != null) {
            count = 1;
        }
        int leftCount = countFullNodes1(root.getLeft());
        int rightCount = countFullNodes1(root.getRight());

        return count + leftCount + rightCount;
    }

    private static int countFullNodes2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.getLeft() != null && node.getRight() != null) {
                ++count;
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return count;

    }
}
