package com.algo.tree;

//Problem: https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubTree572 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode node5 = new TreeNode(5);
        TreeNode root = new TreeNode(3, node4, node5);
        TreeNode subRoot = new TreeNode(4, new TreeNode(10), new TreeNode(2));
        System.out.println(isSubtree(root, subRoot));

    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (isEqual(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
