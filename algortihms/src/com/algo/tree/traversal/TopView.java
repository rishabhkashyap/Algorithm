package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        node6.setRight(new Node(21));

        printTopView(root);
    }

    private static void printTopView(Node root) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        printTopViewHelper(root, nodeMap, 0);
        List<Integer> keys = new ArrayList<>(nodeMap.keySet());
        Collections.sort(keys);
        keys.forEach(k -> System.out.print(nodeMap.get(k).getData() + "\t"));

    }

    private static void printTopViewHelper(Node root, Map<Integer, Node> nodeMap, int i) {
        if (root == null) {
            return;
        }
        if (!nodeMap.containsKey(i)) {
            nodeMap.put(i, root);
        }
        printTopViewHelper(root.getLeft(), nodeMap, i - 1);
        printTopViewHelper(root.getRight(), nodeMap, i + 1);
    }
}
