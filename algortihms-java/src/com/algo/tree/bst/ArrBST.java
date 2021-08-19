package com.algo.tree.bst;

import com.algo.tree.Node;

public class ArrBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = convertToBST(arr);
        traversal(root);

    }

    private static void traversal(Node root) {
        if (root == null) {
            return;
        }
        traversal(root.getLeft());
        traversal(root.getRight());
        System.out.print(root.getData() + "\t");
    }

    private static Node convertToBST(int[] arr) {
        return convertToBST(arr, 0, arr.length - 1);
    }

    private static Node convertToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.setLeft(convertToBST(arr, start, mid - 1));
        root.setRight(convertToBST(arr, mid + 1, end));
        return root;
    }
}
