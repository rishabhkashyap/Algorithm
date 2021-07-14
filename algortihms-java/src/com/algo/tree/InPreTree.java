package com.algo.tree;

public class InPreTree {

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 9, 6, 10, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 9, 10, 7};
        Node root = constructTree(inOrder, preOrder);
        traversePostorder(root);
    }

    private static Node constructTree(int[] inOrder, int[] preOrder) {
        Index index = new Index();
        Node root = constructTreeHelper(inOrder, preOrder, 0, inOrder.length - 1, index);
        return root;
    }

    private static Node constructTreeHelper(int[] inOrder, int[] preOrder, int start, int end, Index preIndex) {
        if (start > end) {
            return null;

        }
        Node root = new Node(preOrder[preIndex.i++]);
        if (start == end) {
            return root;
        }
        int inIndex = search(inOrder, root.getData(), start, end);
        root.setLeft(constructTreeHelper(inOrder, preOrder, start, inIndex - 1, preIndex));
        root.setRight(constructTreeHelper(inOrder, preOrder, inIndex + 1, end, preIndex));
        return root;


    }

    private static int search(int[] inOrder, int key, int start, int end) {
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void traversePostorder(Node root) {
        if (root != null) {
            traversePostorder(root.getLeft());
            traversePostorder(root.getRight());
            System.out.print(root.getData() + "\t");
        }
    }

    private static class Index {
        private int i;
    }


}
