package com.algo.tree;

public class PrePostTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
//        int[] pre = {1, 2, 4, 5, 3, 6, 8, 9, 7};
//        int[] post = {4, 5, 2, 8, 9, 6, 7, 3, 1};
        Node root = construct(pre, post);
        TreeUtil.inOrder(root);
    }

    private static Node construct(int[] pre, int[] post) {
        Index index = new Index();
        return construct(pre, post, index, 0, post.length - 1);
    }

    private static Node construct(int[] pre, int[] post, Index index, int start, int end) {
        if (start > end || index.i >= pre.length) {
            return null;
        }
        Node root = new Node(pre[index.i]);
        ++index.i;
        if (start == end || index.i >= pre.length) {
            return root;
        }
        int loc = search(post, pre[index.i], start, end);
        if (loc >= 0) {
            root.setLeft(construct(pre, post, index, start, loc));
            root.setRight(construct(pre, post, index, loc + 1, end));
        }
        return root;
    }

    private static int search(int[] post, int element, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (post[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private static class Index {
        private int i;
    }
}
