package com.algo.tree;

//Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class InPostTree106 {
    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        var root = constructTree(inorder, postorder);
        traversePreorder(root);
    }

    private static TreeNode constructTree(int[] postorder, int[] inorder) {
        return constructTree(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode constructTree(int[] postorder, int index, int[] inorder, int start, int end) {
        if (start > end || index < 0) {
            return null;
        }
        var node = new TreeNode(postorder[index]);
        var loc = findNodeLocation(inorder, postorder[index], start, end);
        var rightNodeCount = end - loc;
        node.right = constructTree(postorder, index - 1, inorder, loc + 1, end);
        node.right = constructTree(postorder, index - rightNodeCount - 1, inorder, start, loc - 1);
        return node;
    }

    private static int findNodeLocation(int[] preorder, int value, int start, int end) {
        for (var i = start; i <= end; i++) {
            if (preorder[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static void traversePreorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            traversePreorder(root.left);
            traversePreorder(root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
