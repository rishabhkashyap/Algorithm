package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.*;

public class BottomView {

    public static void main(String[] args) {
        Node root = new Node(20);
        Node node8 = new Node(8);
        Node node22 = new Node(22);
        Node node5 = new Node(5);
        Node node3 = new Node(3);
        Node node25 = new Node(25);
        Node node10 = new Node(10);
        Node node14 = new Node(14);
        root.setLeft(node8);
        root.setRight(node22);
        node8.setLeft(node5);
        node8.setRight(node3);
        node22.setRight(node25);
        node3.setLeft(node10);
        node3.setRight(node14);
        printBottomView(root);
    }

    private static void printBottomView(Node root) {
        Map<Integer, NodeContainer> containerMap = new HashMap<>();
        bootomViewHelper(root, containerMap, 0, 0);
        List<Integer> keyList=new ArrayList<>(containerMap.keySet());
        Collections.sort(keyList);
        keyList.forEach(k -> System.out.print(containerMap.get(k).node.getData() + "\t"));

    }

    private static void bootomViewHelper(Node root, Map<Integer, NodeContainer> containerMap, int hd, int level) {
        if (root == null) {
            return;
        }

        if (!containerMap.containsKey(hd)) {
            NodeContainer nodeContainer = new NodeContainer();
            nodeContainer.node = root;
            nodeContainer.level = level;
            containerMap.put(hd, nodeContainer);

        } else {
            NodeContainer container = containerMap.get(hd);
            if (level > container.level) {
                container.node = root;
                container.level = level;
                containerMap.put(hd, container);
            }
        }
        bootomViewHelper(root.getLeft(), containerMap, hd - 1, level + 1);
        bootomViewHelper(root.getRight(), containerMap, hd + 1, level + 1);

    }

    private static class NodeContainer {
        private com.algo.tree.Node node;
        private int level;

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }


}
