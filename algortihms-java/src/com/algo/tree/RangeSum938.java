package com.algo.tree;

public class RangeSum938 {
    static void main() {
        var root = new TreeNode(10);
        var node5 = new TreeNode(5);
        var node15 = new TreeNode(15);
        var node3 = new TreeNode(3);
        var node7 = new TreeNode(7);
        var node18 = new TreeNode(18);
        root.left = node5;
        root.right = node15;
        node5.left = node3;
        node5.right = node7;
        node15.right = node18;
        System.out.println(rangeSumBST1(root, 7, 15));
        System.out.println(rangeSumBST2(root, 7, 15));
    }


    //Leverages property of BST
    //time complexity: O(N)
    private static int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        return root.val + rangeSumBST1(root.right, low, high)
                + rangeSumBST1(root.left, low, high);
    }

    //Binary tree traversal approach
    //time complexity O(N)
    private static int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        var sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        sum += rangeSumBST2(root.left, low, high);
        sum += rangeSumBST2(root.right, low, high);
        return sum;
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
