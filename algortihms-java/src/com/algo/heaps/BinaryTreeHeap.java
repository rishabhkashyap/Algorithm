package com.algo.heaps;

import com.algo.tree.Node;

public class BinaryTreeHeap {
    public static void main(String[] args) {
        Node root = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node10 = new Node(10);
        root.setLeft(node4);
        root.setRight(node3);
        node4.setLeft(node2);
        node4.setRight(node1);


        System.out.println("Binary tree is a heap = " + isHeap(root));

        node4.setRight(node10);

        System.out.println("Binary tree is a heap = " + isHeap(root));

        node4.setRight(null);
        node4.setLeft(null);
        node3.setLeft(node2);
        node3.setRight(node1);
        System.out.println("Binary tree is a heap = " + isHeap(root));
    }

    private static boolean isHeap(Node root) {
        return isHeapHelper(root, size(root), 0);
    }

    private static boolean isHeapHelper(Node root, int size, int index) {
        if (root == null) {
            return true;
        }

        //if binary tree is not complete return false
        if (index >= size) {
            return false;
        }

        //if child node are greater than root node return false
        if ((root.getRight() != null && root.getData() < root.getRight().getData())
                || (root.getLeft() != null && root.getData() < root.getLeft().getData())) {
            return false;
        }

        return isHeapHelper(root.getLeft(), size, 2 * index + 1)
                && isHeapHelper(root.getRight(), size, 2 * index + 2);

    }

    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.getLeft()) + size(root.getRight());

    }


}
