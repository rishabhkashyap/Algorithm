package com.algo.tree;

public class MinNodeDistance {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node6.setRight(node8);
        System.out.println("Min distance between node4 and node5 = " + findMinDistance(root, node4, node5));
        System.out.println("Min distance between node4 and node6 = " + findMinDistance(root, node4, node6));
        System.out.println("Min distance between node3 and node4 = " + findMinDistance(root, node3, node4));
        System.out.println("Min distance between node2 and node4 = " + findMinDistance(root, node2, node4));
        System.out.println("Min distance between node8 and node5 = " + findMinDistance(root, node8, node5));

    }

    private static int findMinDistance(Node root, Node node1, Node node2) {
        Node lca = findLCA(root, node1, node2);
        int pathLength1 = findPathLength(lca, node1);
        int pathLength2 = findPathLength(lca, node2);
        return pathLength1 + pathLength2 - 2;
    }

    private static Node findLCA(Node root, Node node1, Node node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Node left = findLCA(root.getLeft(), node1, node2);
        Node right = findLCA(root.getRight(), node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private static int findPathLength(Node root, Node node) {
        if (root == null) {
            return 0;
        }
        if (root.getData() == node.getData()) {
            return 1;
        }
        int leftDistance = findPathLength(root.getLeft(), node);
        int rightDistance = findPathLength(root.getRight(), node);
        if (leftDistance == 0 && rightDistance == 0) {
            return 0;
        }
        return leftDistance+rightDistance+1;
    }
}
