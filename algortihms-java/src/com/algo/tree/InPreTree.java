package com.algo.tree;

//Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class InPreTree {

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 9, 6, 10, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 9, 10, 7};
        Node root = constructTree(inOrder, preOrder);
        traversePostorder(root);
    }

    private static Node constructTree(int[] inOrder, int[] preOrder) {
        Position rootPos = new Position(0);
        return constructTree(preOrder, rootPos, inOrder, 0, inOrder.length - 1);
    }

    private static Node constructTree(int[] pre, Position rootPos, int[] in, int start, int end) {
        if (start > end || rootPos.index >= pre.length) {
            return null;
        }
        Node node = new Node(pre[rootPos.index++]);
        int loc = find(in, node.getData(), start, end);
        node.setLeft(constructTree(pre, rootPos, in, start, loc - 1));
        node.setRight(constructTree(pre, rootPos, in, loc + 1, end));
        return node;
    }

    private static int find(int[] arr, int key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static void traversePostorder(Node root) {
        if (root != null) {
            traversePostorder(root.getLeft());
            traversePostorder(root.getRight());
            System.out.print(root.getData() + "\t");
        }
    }

    private static class Position {
        private int index;

        private Position(int value) {
            this.index = value;
        }
    }


}
