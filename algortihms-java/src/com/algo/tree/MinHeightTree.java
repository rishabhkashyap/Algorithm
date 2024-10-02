package com.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class MinHeightTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(new Node(22));
//        Node root = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        root.setLeft(node2);
//        root.setRight(node3);
//        node2.setLeft(node4);
//        node2.setRight(node5);
        System.out.println("Min depth of tree = " + findMinDepth(root));
        System.out.println("Minimum height of tree = " + getMinHeight1(root));
        System.out.println("Minimum height of tree = " + getMinHeight2(root));
    }

    //Leetcode solution
//    Base Case:
//    If the root is null, return 0 since there are no nodes.
//    Recursive Case:
//    Recursively calculate the minimum depth of the left and right subtrees.
//    If one subtree is missing (i.e., depth 0), return the depth of the other subtree plus 1 (for the current node)
//    If both subtrees exist, return the smaller depth of the two plus 1 (for the current node).
//    Time complexity O(N)
//    Space complexity O(H) where H is height of the tree
    private static int findMinDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        int left = findMinDepth(root.getLeft());
        int right = findMinDepth(root.getRight());
        if (root.getLeft() == null) {
            return right + 1;
        }
        if (root.getRight() == null) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    private static int getMinHeight1(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        //Null check is added because null node will return 0 and when min is taken
        // id doesn't give the expected result, so avoid null child
        if (root.getLeft() == null) {
            return getMinHeight1(root.getRight()) + 1;
        }
        if (root.getRight() == null) {
            return getMinHeight1(root.getLeft()) + 1;
        }
        return Math.min(getMinHeight1(root.getLeft()), getMinHeight1(root.getRight())) + 1;
    }

    private static int getMinHeight2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                if (node.getLeft() == null && node.getRight() == null) {
                    return height + 1;
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            } else {
                ++height;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return height;
    }
}