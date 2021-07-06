package com.algo.tree;

public class TruncatedTreePathSum {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node6.setLeft(node3);
        node6.setRight(node8);
        node8.setLeft(node4);
        node8.setRight(node2);
        node2.setRight(node5);
        node4.setLeft(node1);
        node4.setRight(node7);
        int k = 20;
        System.out.println("Preorder traversal");
        TreeUtil.preOrder(node6);
        System.out.println();
        Node result = removePaths(node6, k);
        TreeUtil.preOrder(result);
    }

    private static Node removePaths(Node root, int k) {
        return removePaths(root, k, 0);
    }

    private static Node removePaths(Node root, int k, int sum) {
        if (root == null) {
            return null;
        }
        sum += root.getData();
        root.setLeft(removePaths(root.getLeft(), k, sum));
        root.setRight(removePaths(root.getRight(), k, sum));
        if (isLeaf(root) && sum < k) {
            return null;
        }
        return root;
    }

    private static boolean isLeaf(Node root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}
