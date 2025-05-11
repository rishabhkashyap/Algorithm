package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth662 {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        var node3 = new TreeNode(3);
        var node2 = new TreeNode(2);
        var node5 = new TreeNode(5);
        var node33 = new TreeNode(3);
        var node9 = new TreeNode(9);
        root.left = node3;
        root.right = node2;
        node3.left = node5;
        node3.right = node33;
        node2.right = node9;
        System.out.println(findTreeWidth(root));
    }

    private static int findTreeWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Child> queue = new LinkedList<>();
        var maxWidth = 1;
        queue.add(new Child(root, 0));
        while (!queue.isEmpty()) {
            int level = queue.size();
            var left = queue.peek().index;
            var right = queue.peek().index;
            var i = 0;
            while (i < level) {
                var loc = queue.remove();
                right = loc.index;
                var node = loc.node;
                if (node.left != null) {
                    queue.add(new Child(node.left, 2 * loc.index + 1));
                }
                if (node.right != null) {
                    queue.add(new Child(node.right, 2 * loc.index + 2));
                }
                ++i;
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    private record Child(
            TreeNode node,
            int index
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
