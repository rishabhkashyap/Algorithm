package com.algo.tree;

public class CompleteTree {

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
        //node8.setRight(node5);
        //node2.setLeft(node7);
        node2.setRight(new Node(22));
        System.out.println("Tree is a complete tree = " + isCompleteTree(root));

    }

    private static boolean isCompleteTree(Node root) {
        int index = 0;
        int size = treeSize(root);
        return completeTree(root, size, index);
    }


    private static boolean completeTree(Node root, int size, int index) {
        if (root == null) {
            return true;
        }
        if (index >= size) {
            return false;
        }
        boolean leftComplete = completeTree(root.getLeft(), size, 2 * index + 1);
        boolean rightComplete = completeTree(root.getRight(), size, 2 * index + 2);
        return leftComplete && rightComplete;
    }

    private static int treeSize(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = treeSize(root.getLeft());
        int rightCount = treeSize(root.getRight());
        return leftCount + rightCount + 1;
    }
}
