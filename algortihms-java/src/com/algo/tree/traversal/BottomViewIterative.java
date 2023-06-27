package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BottomViewIterative {
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
        bottomView(root);
    }

    private static void bottomView(Node root) {
        Queue<NodeContainer> queue = new LinkedList<>();
        Map<Integer, NodeContainer> map = new HashMap<>();
        Node current = root;
        queue.add(new NodeContainer(root, 0));
        while (!queue.isEmpty()) {
            NodeContainer nodeContainer = queue.remove();
            map.put(nodeContainer.getHd(), nodeContainer);
            if (nodeContainer.getNode().getLeft() != null) {
                queue.add(new NodeContainer(nodeContainer.getNode().getLeft(), nodeContainer.getHd() - 1));
            }
            if (nodeContainer.getNode().getRight() != null) {
                queue.add(new NodeContainer(nodeContainer.getNode().getRight(), nodeContainer.getHd() + 1));
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((e1, e2) -> e1 - e2);
        list.forEach(e -> System.out.print(map.get(e).getNode().getData() + "\t"));
    }

    private static class NodeContainer {
        private Node node;
        private Integer hd;

        public NodeContainer(Node node, Integer hd) {
            this.node = node;
            this.hd = hd;
        }

        public Node getNode() {
            return node;
        }

        public Integer getHd() {
            return hd;
        }
    }
}
