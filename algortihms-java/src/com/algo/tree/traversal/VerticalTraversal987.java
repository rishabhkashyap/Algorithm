package com.algo.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

public class VerticalTraversal987 {
    static void main() {
        var root = new TreeNode(3);
        var node9 = new TreeNode(9);
        var node20 = new TreeNode(20);
        var node15 = new TreeNode(15);
        var node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        var result = getNodesInVerticalOrder(root);
        System.out.println(result);

    }

    private static List<List<Integer>> getNodesInVerticalOrder(TreeNode root) {
        Map<Integer, List<NodeData>> map = new TreeMap<>();
        getNodesInVerticalOrder(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (List<NodeData> list : map.values()) {
            List<Integer> temp = list.stream()
                    .sorted(
                            (e1, e2) -> !e1.row.equals(e2.row) ? e1.row - e2.row : e1.val - e2.val
                    )
                    .map(e -> e.val)
                    .collect(Collectors.toList());
            result.add(temp);
        }
        return result;
    }

    private static void getNodesInVerticalOrder(TreeNode root, int row, int col, Map<Integer, List<NodeData>> map) {
        if (root == null) {
            return;
        }
        List<NodeData> list = map.getOrDefault(col, new ArrayList<>());
        list.add(new NodeData(root.val, row));
        map.put(col, list);
        getNodesInVerticalOrder(root.left, row + 1, col - 1, map);
        getNodesInVerticalOrder(root.right, row + 1, col + 1, map);
    }

    private record NodeData(Integer val, Integer row) {
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
