package com.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static void main(String[] args) {
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
        var result = getPaths(root, target);
        result.forEach(System.out::println);
    }

    private static List<List<Integer>> getPaths(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPaths(root, target, 0, path, result);
        return result;
    }

    private static void getPaths(TreeNode root, int target, int sum, List<Integer> path,
                                  List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && target == sum) {
            result.add(new ArrayList<>(path));
        }
        getPaths(root.left, target, sum, path, result);
        getPaths(root.right, target, sum, path, result);
        path.remove(path.size() - 1);
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
