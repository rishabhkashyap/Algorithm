package com.algo.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/path-sum-iii/description/

public class PathSumIII437 {

    public static void main(String[] args) {
        var root = new TreeNode(3);
        var node5 = new TreeNode(5);
        var node1 = new TreeNode(1);
        var node6 = new TreeNode(6);
        var node2 = new TreeNode(2);
        var node0 = new TreeNode(0);
        var node8 = new TreeNode(8);
        var node7 = new TreeNode(7);
        var node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        var target = 14;
        System.out.println(countPathSum1(root, target));
        System.out.println(countPathSum2(root, target));

    }

    private static int countPathSum1(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }
        var count = countPathSum1(root, target, 0L);
        count += countPathSum1(root.left, target);
        count += countPathSum1(root.right, target);
        return count;
    }

    private static int countPathSum1(TreeNode root, long target, long sum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        var leftCount = countPathSum1(root.left, target, sum);
        var rightCount = countPathSum1(root.right, target, sum);
        if (sum == target) {
            return leftCount + rightCount + 1;
        }
        return leftCount + rightCount;

    }

//    Start at the root and maintain a currentSum (prefix sum).
//    Check how many times currentSum - targetSum has occurred → This gives the count of valid paths ending at the current node.
//    Add currentSum to the hash map.
//    Recur for left and right subtrees.
//    Backtrack: Remove currentSum when returning to the previous node to maintain correctness.
    private static int countPathSum2(TreeNode root, long target) {
        Map<Long, Integer> map = new HashMap<>();
        // TO deal with scenario where node value is equal to target
        map.put(0L, 1);
        return countPathSum2(root, target, 0, map);
    }

    private static int countPathSum2(TreeNode root, long target, long sum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        var count = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += countPathSum2(root.left, target, sum, map)
                + countPathSum2(root.right, target, sum, map);
        map.put(sum, map.get(sum) - 1);
        return count;
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
