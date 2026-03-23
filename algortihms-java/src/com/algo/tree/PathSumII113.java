package com.algo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

//Problem: https://leetcode.com/problems/path-sum-ii/description/

public class PathSumII113 {
    static void main() {
        var target = 14;
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
        var result = getPaths1(root, target);
        System.out.println(result);
        System.out.println();
        result = getPaths2(root, target);
        System.out.println(result);
    }

    private static List<List<Integer>> getPaths1(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPaths1(root, target, 0, path, result);
        return result;
    }

    private static void getPaths1(TreeNode root, int target, int sum, List<Integer> path,
                                  List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && target == sum) {
            result.add(new ArrayList<>(path));
        }
        getPaths1(root.left, target, sum, path, result);
        getPaths1(root.right, target, sum, path, result);
        path.removeLast();
    }

    private static List<List<Integer>> getPaths2(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<PathSummary> stack = new ArrayDeque<>();
        stack.push(new PathSummary(root, List.of(root.val), root.val));
        List<List<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            var summary = stack.pop();
            var node = summary.node;
            var path = summary.path;
            if (summary.sum == targetSum && node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                List<Integer> list = new ArrayList<>(path);
                list.add(node.left.val);
                stack.push(new PathSummary(node.left, list, summary.sum + node.left.val));
            }
            if (node.right != null) {
                List<Integer> list = new ArrayList<>(path);
                list.add(node.right.val);
                stack.push(new PathSummary(node.right, list, summary.sum + node.right.val));
            }
        }
        return result;
    }

    private record PathSummary(TreeNode node, List<Integer> path, int sum) {
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
