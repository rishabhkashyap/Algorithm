package com.algo.tree;

import com.algo.tree.traversal.PreOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class InsertLevelOrder {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        PreOrderTraversal.preOrder1(node1);
        System.out.println();
        insertLevelOrder(node1, new Node(7));
        insertLevelOrder(node1, new Node(9));
        PreOrderTraversal.preOrder1(node1);


    }

    private static void insertLevelOrder(Node root, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            } else {
                current.setLeft(node);
                break;
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            } else {
                current.setRight(node);
                break;
            }
        }
    }
}
