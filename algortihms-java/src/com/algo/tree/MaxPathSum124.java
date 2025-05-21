package com.algo.tree;

//Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class MaxPathSum124 {
    public static void main(String[] args) {
        var root = new TreeNode(10);
        var node10 = new TreeNode(10);
        var node20 = new TreeNode(20);
        var node1 = new TreeNode(1);
        var node25 = new TreeNode(-25);
        var node3 = new TreeNode(3);
        var node4 = new TreeNode(4);
        var node2 = new TreeNode(2);
        root.left = node2;
        root.right = node10;
        node2.left = node20;
        node2.right = node1;
        node10.right = node25;
        node25.left = node3;
        node25.right = node4;
        System.out.println("Max path sum = " + maxSum(root));
    }

    private static int maxSum(TreeNode root) {
        var sum = new Sum(Integer.MIN_VALUE);
        maxSum(root, sum);
        return sum.value;
    }

    private static int maxSum(TreeNode root, Sum sum) {
        if (root == null) {
            return 0;
        }
        var leftSum = maxSum(root.left, sum);
        var rightSum = maxSum(root.right, sum);
        var maxPath = Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
        var rootIncluded = leftSum + rightSum + root.val;
        sum.value = Math.max(sum.value, Math.max(maxPath, rootIncluded));
        return maxPath;
    }

    private static class Sum{

        private int value;

        public Sum(int value) {
            this.value = value;
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
