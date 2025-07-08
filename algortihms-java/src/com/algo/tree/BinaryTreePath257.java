package com.algo.tree;

import java.util.ArrayList;
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
        result = getPaths3(root);
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
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, ""));
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            pair.path = pair.path + pair.node.val;
            if (pair.node.right == null && pair.node.left == null) {
                result.add(pair.path);
            }
            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, pair.path + "->"));
            }
            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, pair.path + "->"));
            }
        }
        return result;
    }

    private static List<String> getPaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        Pair pair = new Pair(root, "");
        getPaths3(root, pair, result);
        return result;
    }

    private static void getPaths3(TreeNode root, Pair pair, List<String> result) {
        if (root == null) {
            return;
        }
        pair.path = pair.path + root.val;
        getPaths3(root.left, new Pair(root.left, pair.path + "->"), result);
        getPaths3(root.right, new Pair(root.right, pair.path + "->"), result);
        if (root.left == null && root.right == null) {
            result.add(pair.path);
        }
    }

    private static class Pair {
        TreeNode node;
        String path;

        public Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
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
