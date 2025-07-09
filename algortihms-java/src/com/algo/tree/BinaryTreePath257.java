package com.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Problem: https://leetcode.com/problems/binary-tree-paths/description/
public class BinaryTreePath257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node3;
        root.right = node2;
        node2.right = node5;
        List<String> result = getPaths(root);
        result.forEach(e -> System.out.print(e + "\t"));
        result = getPaths2(root);
        System.out.println();
        result.forEach(e -> System.out.print(e + "\t"));
    }

    private static List<String> getPaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        getPaths(root, path, result);
        return result;
    }

    private static void getPaths(TreeNode root, List<String> path, List<String> result) {
        if (root == null) {
            return;
        }
        path.add(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", path));
        }
        getPaths(root.left, path, result);
        getPaths(root.right, path, result);
        path.remove(path.size() - 1);
    }

    //Iterative solution
    private static List<String> getPaths2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        var sb = new StringBuilder();
        sb.append(root.val);
        stack.push(new Pair(root, sb));
        while (!stack.isEmpty()) {
            var pair = stack.pop();
            var node = pair.node;
            var path = pair.path;
            if (node.left == null && node.right == null) {
                result.add(path.toString());
            } else {
                if (node.right != null) {
                    sb = new StringBuilder(path);
                    sb.append("->");
                    sb.append(node.right.val);
                    var rightPair = new Pair(node.right, sb);
                    stack.push(rightPair);
                }
                if (node.left != null) {
                    sb = new StringBuilder(path);
                    sb.append("->");
                    sb.append(node.left.val);
                    var leftPair = new Pair(node.left, sb);
                    stack.push(leftPair);
                }
            }
        }
        return result;
    }

    private record Pair(
            TreeNode node,
            StringBuilder path
    ) {
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
