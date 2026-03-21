package com.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Problem: https://leetcode.com/problems/binary-tree-paths/description/
public class BinaryTreePath257 {
     static void main() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        root.left = node3;
        root.right = node2;
        node2.right = node5;
        List<String> result = getPaths1(root);
        result.forEach(e -> System.out.print(e + "\t"));
        result = getPaths2(root);
        System.out.println();
        result.forEach(e -> System.out.print(e + "\t"));
        result = getPaths3(root);
        System.out.println();
        result.forEach(e -> System.out.print(e + "\t"));
    }

    private static List<String> getPaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        getPaths1(root, path, result);
        return result;
    }

    private static void getPaths1(TreeNode root, List<String> path, List<String> result) {
        if (root == null) {
            return;
        }
        path.add(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", path));
        }
        getPaths1(root.left, path, result);
        getPaths1(root.right, path, result);
        path.remove(path.size() - 1);
    }

    //cleaner recursive approach
    private static List<String> getPaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        var path = new StringBuilder();
        getPaths2(root, path, paths);
        return paths;
    }

    private static void getPaths2(TreeNode root, StringBuilder path, List<String> paths){
        if(root == null){
            return;
        }
        var length = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null){
            paths.add(path.toString());
        }
        path.append("->");
        getPaths2(root.left, path, paths);
        getPaths2(root.right, path, paths);
        path.setLength(length);
    }

    //Iterative solution
    private static List<String> getPaths3(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, String.valueOf(root.val)));
        while (!stack.isEmpty()) {
            var pair = stack.pop();
            var node = pair.node;
            var path = pair.path;
            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                if (node.right != null) {
                    var rightPair = new Pair(node.right, path + "->" + node.right.val);
                    stack.push(rightPair);
                }
                if (node.left != null) {
                    var leftPair = new Pair(node.left, path + "->" + node.left.val);
                    stack.push(leftPair);
                }
            }
        }
        return result;
    }

    private record Pair(
            TreeNode node,
            String path
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
