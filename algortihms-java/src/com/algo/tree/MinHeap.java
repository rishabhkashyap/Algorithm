package com.algo.tree;

public class MinHeap {
    public static void main(String[] args) {
        Node root = new Node(6);
        Node node7 = new Node(7);
        Node node12 = new Node(12);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node17 = new Node(17);
        root.setLeft(node7);
        root.setRight(node12);
        node7.setLeft(node10);
        node7.setRight(node15);
        node12.setLeft(node17);
        System.out.println("Is min heap = " + isMeanHeap(root));
    }

    private static boolean isMeanHeap(Node root) {
        int size = getSize(root);
        return isMeanHeap(root, size, 0);
    }

    private static boolean isMeanHeap(Node root, int size, int index) {
        if (root == null) {
            return true;
        }
        if (index >= size) {
            return false;
        }
        if (!checkMinHeapCondition(root, root.getLeft(), root.getRight())) {
            return false;
        }
        return isMeanHeap(root.getLeft(), size, 2 * index + 1)
                && isMeanHeap(root.getRight(), size, 2 * index + 2);

    }

    private static boolean checkMinHeapCondition(Node root, Node left, Node right) {
        if (left != null && left.getData() < root.getData()
                || right != null && right.getData() < root.getData()) {
            return false;
        }
        return true;
    }

    private static int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.getLeft())
                + getSize(root.getRight()) + 1;
    }
}
