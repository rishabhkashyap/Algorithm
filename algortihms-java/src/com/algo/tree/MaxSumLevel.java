package com.algo.tree;


import com.algo.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumLevel {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node0=new Node(0);
        Node node1=new Node(1);
        root.setLeft(node8);
        root.setRight(node2);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(new Node(22));

//        node1.setLeft(node7);
//        node1.setRight(node0);
//        node7.setLeft(new Node(7));
//        node7.setRight(new Node(-8));
        System.out.println("Level with max sum = " + getLevelWithMaxSum(root));

    }

    private static int getLevelWithMaxSum(Node root) {
        if (root == null) {
            return 0;
        }
        int level = 1;
        int maxLevel = 0;
        int maxsum = Integer.MIN_VALUE;
        int currentSum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                currentSum += node.getData();
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
            } else {
                if (currentSum > maxsum) {
                    maxLevel = level;
                    maxsum=currentSum;
                }
                currentSum = 0;
                ++level;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return maxLevel;
    }
}
