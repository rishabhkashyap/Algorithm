package com.algo.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCABinaryTree {
    static void main() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        System.out.println("Single traversal approach");
        System.out.println(findLCA1(root, node4, node5).getData());
        System.out.println(findLCA1(root, node4, node6).getData());
        System.out.println(findLCA1(root, node3, node4).getData());
        System.out.println(findLCA1(root, node2, node4).getData());

        System.out.println("\nFind path approach");
        System.out.println(findLCA2(root, node4, node5).getData());
        System.out.println(findLCA2(root, node4, node6).getData());
        System.out.println(findLCA2(root, node3, node4).getData());
        System.out.println(findLCA2(root, node2, node4).getData());

        System.out.println("\nRecursive approach to handle scenario where nodes are not part of the tree");
        System.out.println(findLCA3(root, node4, node5).getData());
        System.out.println(findLCA3(root, node4, node6).getData());
        System.out.println(findLCA3(root, node3, node4).getData());
        System.out.println(findLCA3(root, node2, new Node(100)));


    }

    private static Node findLCA1(Node root, Node node1, Node node2) {
        if (root == null) {
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        Node left = findLCA1(root.getLeft(), node1, node2);
        Node right = findLCA1(root.getRight(), node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    //Iterative approach
    //This solution also handle scenario where node1 or node2 or both are not part of the tree
    private static Node findLCA2(Node root, Node node1, Node node2) {
        if (root == null) {
            return null;
        }
        Map<Node, Node> parentMap = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        parentMap.put(root, null);
        while (!parentMap.containsKey(node1) || !parentMap.containsKey(node2)) {
            if (stack.isEmpty()) {
                //This means that one of node1 or node2 is not part of the tree.
                return null;
            }
            var node = stack.pop();
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
                parentMap.put(node.getLeft(), node);
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
                parentMap.put(node.getRight(), node);
            }
        }
        //Get path of node1 ie node1 to root
        Set<Node> path = new HashSet<>();
        while (node1 != null) {
            path.add(node1);
            node1 = parentMap.get(node1);
        }
        //search for first node that is common in node1 and node2 paths
        while (!path.contains(node2)) {
            node2 = parentMap.get(node2);
        }
        return node2;
    }

    //Recursive solution that handle scenarios where node1 or node2 or both are not part of the tree

    private static Node findLCA3(Node root, Node node1, Node node2) {
        var nodeCount = new NodeCount();
        var result = findLCA3(root, node1, node2, nodeCount);
        return nodeCount.val == 2 ? result : null;
    }

    //Use postorder traversal to update nodeCount
    private static Node findLCA3(Node root, Node node1, Node node2, NodeCount nodeCount) {
        if (root == null) {
            return null;
        }
        var left = findLCA3(root.getLeft(), node1, node2, nodeCount);
        var right = findLCA3(root.getRight(), node1, node2, nodeCount);
        if (root == node1 || root == node2) {
            ++nodeCount.val;
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    private static class NodeCount{
        int val;
    }


}
