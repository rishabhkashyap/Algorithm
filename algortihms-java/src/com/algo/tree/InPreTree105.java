package com.algo.tree;

//Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class InPreTree105 {

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 9, 6, 10, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 9, 10, 7};
        var root = constructTree(preOrder, inOrder);
        traversePostorder(root);
    }

    private static TreeNode constructTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private static TreeNode constructTree(int[] preorder, int index, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        var node = new TreeNode(preorder[index]);
        var loc = findNodeLocation(inorder, preorder[index], start, end);
        var leftNodeCount = loc - start;
        node.left = constructTree(preorder, index + 1, inorder, start, loc - 1);
        node.right = constructTree(preorder, index + leftNodeCount + 1, inorder, loc + 1, end);
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



    private static void traversePostorder(TreeNode root) {
        if (root != null) {
            traversePostorder(root.left);
            traversePostorder(root.right);
            System.out.print(root.val + "\t");
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
