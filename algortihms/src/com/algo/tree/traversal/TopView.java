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
        node3.setLeft(new Node(10));
        node6.setRight(new Node(7));

        printTopView(root);
        System.out.println();
        printTopIterative(root);
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

    private static void printTopIterative(Node root) {
        if (root == null) {
            return;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        QueueNode queueNode = new QueueNode(root, 0);
        queue.add(queueNode);
        while (!queue.isEmpty()) {
            QueueNode currentNode = queue.remove();
            if (!map.containsKey(currentNode.hd)) {
                map.put(currentNode.hd, currentNode.node);
            }
            if (currentNode.node.getLeft() != null) {
                queue.add(new QueueNode(currentNode.node.getLeft(), currentNode.hd - 1));
            }
            if (currentNode.node.getRight() != null) {
                queue.add(new QueueNode(currentNode.node.getRight(), currentNode.hd + 1));
            }


        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        keys.forEach(k -> System.out.print(map.get(k).getData() + "\t"));


    }

    private static class QueueNode {
        private Node node;
        private int hd;

        public QueueNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
