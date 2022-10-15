package com.algo.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrderTraversal102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(traverseLevelOrder1(root));
        System.out.println(traverseLevelOrder2(root));

    }

    private static List<List<Integer>> traverseLevelOrder1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                result.add(level);
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> traverseLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
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
