package com.algo.tree;

import java.util.ArrayList;
import java.util.List;

public class LCABinaryTree {
    public static void main(String[] args) {
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

    private static Node findLCA2(Node root, Node node1, Node node2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        findPath(root, node1, path1);
        findPath(root, node2, path2);
        int i = 0;
        Node lca = null;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) == path2.get(i)) {
                lca = path1.get(i);
            } else {
                break;
            }
            ++i;
        }
        return lca;

    }

    private static boolean findPath(Node root, Node node, List<Node> path) {
        if (root == null) {
            return false;
        }
        boolean left = findPath(root.getLeft(), node, path);
        boolean right = findPath(root.getRight(), node, path);
        if (left || right) {
            path.add(0, root);
            return true;
        }
        if (root == node) {
            path.add(root);
            return true;
        }
        return false;
    }
}
