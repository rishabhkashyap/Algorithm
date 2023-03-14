package com.algo.tree;
//Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class InPostTree106 {
    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        Node root = constructTree(inorder, postorder);
        traversePreorder(root);
    }

    private static Node constructTree(int[] inorder, int[] postorder) {
        Position rootPos = new Position(postorder.length-1);
        return constructTree(postorder, rootPos, inorder, 0, inorder.length - 1);

    }

    private static Node constructTree(int[] post, Position rootPos, int[] in, int start, int end) {
        if (start > end || rootPos.index < 0) {
            return null;
        }
        Node node = new Node(post[rootPos.index--]);
        int loc = find(in, node.getData(), start, end);
        node.setRight(constructTree(post, rootPos, in, loc + 1, end));
        node.setLeft(constructTree(post, rootPos, in, start, loc - 1));
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


    private static void traversePreorder(Node root) {
        if (root != null) {
            System.out.print(root.getData() + "\t");
            traversePreorder(root.getLeft());
            traversePreorder(root.getRight());
        }
    }

    private static class Position {
        private int index;

        private Position(int value) {
            this.index = value;
        }
    }
}
