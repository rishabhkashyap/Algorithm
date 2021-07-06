package com.algo.tree;

public class TruncatedTreePathLength {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node7);
        node1.setRight(node3);
        node3.setRight(node6);
        node6.setLeft(node8);
        System.out.println("Inorder traversal");
        TreeUtil.inOrder(node1);
        System.out.println();
        Node result = truncateTree(node1, 4);
        TreeUtil.inOrder(result);
    }

    private static Node truncateTree(Node root, int k) {
        return truncateTree(root, k, 0);
    }

    private static Node truncateTree(Node root, int k, int length) {
        if (root == null) {
            return null;
        }
        length+=1;
        root.setLeft(truncateTree(root.getLeft(), k, length));
        root.setRight(truncateTree(root.getRight(), k, length));
        if (length < k && isLeaf(root)) {
            return null;
        }
        return root;
    }

    private static boolean isLeaf(Node root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}
