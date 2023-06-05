package com.algo.tree;

//Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class MaxPathSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node1 = new Node(1);
        Node node25 = new Node(-25);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        root.setLeft(node2);
        root.setRight(node10);
        node2.setLeft(node20);
        node2.setRight(node1);
        node10.setRight(node25);
        node25.setLeft(node3);
        node25.setRight(node4);
        System.out.println("\nMax path sum = " + maxPathSum(root));


    }

    private static int maxPathSum(Node root) {
        PathSum pathSum = new PathSum();
        //If maxPathSum value is returned , it will give max path sum from root to leaves
        maxPathSum(root, pathSum);
        return pathSum.getSum();

    }

    private static int maxPathSum(Node root, PathSum pathSum) {
        if (root == null) {
            return 0;
        }
        //If left or right subtree sum comes as negative, it's not added as to the sum
        int leftSum = Math.max(maxPathSum(root.getLeft(), pathSum), 0);
        int rightSum = Math.max(maxPathSum(root.getRight(), pathSum), 0);
        int maxSum = Math.max(leftSum, rightSum) + root.getData();
        int rootIncluded = leftSum + rightSum + root.getData();
        pathSum.setSum(Math.max(rootIncluded, pathSum.getSum()));
        return maxSum;
    }

    private static class PathSum {
        private int sum;

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }

}
