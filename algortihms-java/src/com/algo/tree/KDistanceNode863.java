package com.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class KDistanceNode863 {
    public static void main(String[] args) {
        var k = 2;
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
        System.out.print(findKDistanceNodes(root, node5, k));
    }

    private static List<Integer> findKDistanceNodes(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> map = getParentMap(root);
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target.val);
        while (k > 0 && !queue.isEmpty()) {
            var count = queue.size();
            while (count > 0) {
                var temp = queue.remove();
                if (temp.right != null && !visited.contains(temp.right.val)) {
                    queue.add(temp.right);
                    visited.add(temp.right.val);
                }
                if (temp.left != null && !visited.contains(temp.left.val)) {
                    queue.add(temp.left);
                    visited.add(temp.left.val);
                }
                var parent = map.get(temp.val);
                if (parent != null && !visited.contains(parent.val)) {
                    queue.add(parent);
                    visited.add(parent.val);
                }
                --count;
            }
            --k;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove().val);
        }
        return result;
    }

    private static Map<Integer, TreeNode> getParentMap(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var count = queue.size();
            while (count > 0) {
                var temp = queue.remove();
                if (temp.left != null) {
                    map.put(temp.left.val, temp);
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    map.put(temp.right.val, temp);
                    queue.add(temp.right);
                }
                --count;
            }
        }
        return map;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}










