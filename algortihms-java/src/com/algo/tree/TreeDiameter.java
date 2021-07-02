package com.algo.tree;

import java.util.Map;

public class TreeDiameter {
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
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node7);
        node5.setRight(node8);
        node3.setRight(node6);
        node6.setRight(node9);
        node9.setLeft(node10);
        node9.setRight(node11);
        node10.setRight(node12);

        System.out.println("Diameter of tree = " + findDiameter1(root));
        System.out.println("Diameter of tree = " + findDiameter2(root));


    }

    private static int findDiameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        int leftDiameter = findDiameter1(root.getLeft());
        int rightDiameter = findDiameter1(root.getRight());
        int rootIncludedDiameter = leftHeight + 1 + rightHeight;
        return Math.max(rootIncludedDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;

    }

    private static int findDiameter2(Node root) {
        NodeHeight nodeHeight = new NodeHeight();
        return findDiameter2(root, nodeHeight);
    }

    private static int findDiameter2(Node root, NodeHeight nodeHeight) {
        if (root == null) {
            nodeHeight.setHeight(0);
            return 0;
        }
        NodeHeight leftNodeHeight = new NodeHeight();
        NodeHeight rightNodeHeight = new NodeHeight();
        int leftDiameter = findDiameter2(root.getLeft(), leftNodeHeight);
        int rightDiameter = findDiameter2(root.getRight(), rightNodeHeight);
        nodeHeight.setHeight(Math.max(leftNodeHeight.getHeight(),rightNodeHeight.getHeight())+1);
        int rootIncludedDiameter=leftNodeHeight.getHeight()+1+rightNodeHeight.getHeight();
        return Math.max(rootIncludedDiameter,Math.max(leftDiameter,rightDiameter));

    }

    private static class NodeHeight {
        private int height;

        public NodeHeight() {
            this.height = 0;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }


}
