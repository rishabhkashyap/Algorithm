package com.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal107 {

    public static void main(String[] args) {
        var root = new TreeNode(3);
        var node9 = new TreeNode(9);
        var node20 = new TreeNode(20);
        var node15 = new TreeNode(15);
        var node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> result = levelOrderRev(root);
        System.out.println(result);
    }

    private static List<List<Integer>> levelOrderRev(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            var size = queue.size();
            List<Integer> nodes = new ArrayList<>();
            while (size > 0) {
                var node = queue.remove();
                nodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                --size;
            }
            stack.push(nodes);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
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
