package com.algo.tree;

import java.util.Queue;
import java.util.LinkedList;

public class DeepNode {

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node22 = new Node(22);
        Node node23 = new Node(23);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(node22);
        node22.setLeft(node23);
        node23.setRight(new Node(35));
        findDeepestNode1(root);

        System.out.println("Deepest node in tree = " + findDeepestNode2(root).getData());
        System.out.println("Deepest node in tree = " + findDeepestNode3(root).getData());

    }

    private static void findDeepestNode1(Node root) {
        findDeepestNode1(root, getHeight(root));
    }

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static void findDeepestNode1(Node root, int height) {

        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.println("Deepest node in tree = " + root.getData());
        }
        findDeepestNode1(root.getLeft(), height-1);
        findDeepestNode1(root.getRight(), height-1);


    }

    //This approach gives height and deepest node in one cycle of recursion calls

    private static Node findDeepestNode2(Node root) {
        DeepNodeInfo deepNodeInfo = new DeepNodeInfo(-1);
        findDeepestNode2(root, deepNodeInfo, 1);
        return deepNodeInfo.getNode();

    }

    private static void findDeepestNode2(Node root, DeepNodeInfo deepNodeInfo, int level) {
        if (root == null) {
            return;
        }
        if (level > deepNodeInfo.getMaxLevel()) {
            deepNodeInfo.setNode(root);
            deepNodeInfo.setMaxLevel(level);
        }
        findDeepestNode2(root.getLeft(), deepNodeInfo, level + 1);
        findDeepestNode2(root.getRight(), deepNodeInfo, level + 1);

    }

    private static class DeepNodeInfo {

        private int maxLevel;
        private Node node;

        public DeepNodeInfo(int maxLevel) {
            this.maxLevel = maxLevel;
            this.node = null;
        }


        public int getMaxLevel() {
            return maxLevel;
        }

        public void setMaxLevel(int maxLevel) {
            this.maxLevel = maxLevel;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

    }

    //Finding deepest node using level order traversal
    private static Node findDeepestNode3(Node root) {
        if (root == null) {
            return null;
        }
        Node node = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return node;
    }

}
