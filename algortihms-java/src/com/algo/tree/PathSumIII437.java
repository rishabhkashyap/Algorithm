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
        System.out.println(countPathSum3(root, target));

    }

    //Time complexity: O(N^2)
    private static int countPathSum1(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }
        var count = helper1(root, target);
        count += countPathSum1(root.left, target);
        count += countPathSum1(root.right, target);
        return count;
    }

    //Post order computation
    private static int helper1(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        var leftCount = helper1(root.left, sum);
        var rightCount = helper1(root.right, sum);
        if (sum == 0) {
            return leftCount + rightCount + 1;
        }
        return leftCount + rightCount;
    }

    //Time complexity: O(N^2)
    private static int countPathSum2(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }
        var count = helper2(root, target);
        count += countPathSum2(root.left, target);
        count += countPathSum2(root.right, target);
        return count;
    }

    //Preorder computation
    private static int helper2(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        var count = sum == 0 ? 1 : 0;
        count += helper2(root.left, sum);
        count += helper2(root.right, sum);
        return count;
    }

//    Start at the root and maintain a currentSum (prefix sum).
//    Check how many times currentSum - targetSum has occurred → This gives the count of valid paths ending at the current node.
//    Add currentSum to the hash map.
//    Recur for left and right subtrees.
//    Backtrack: Remove currentSum when returning to the previous node to maintain correctness.
//    Time complexity: O(N)
    private static int countPathSum3(TreeNode root, long target) {
        Map<Long, Integer> map = new HashMap<>();
        // TO deal with scenario where node value is equal to target
        map.put(0L, 1);
        return countPathSum3(root, target, 0, map);
    }

    private static int countPathSum3(TreeNode root, long target, long sum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        var count = map.getOrDefault(sum - target, 0);
        //Prefix sum is added after getting count because in edge case where :
        //root node is 1 and tree contains only one node
        //target = 0
        //op = 0
        //if prefix sum is added before getting count it will result in wrong answer
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += countPathSum3(root.left, target, sum, map)
                + countPathSum3(root.right, target, sum, map);
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
