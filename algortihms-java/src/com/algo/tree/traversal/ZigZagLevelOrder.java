package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        Node root = new Node(20);
        Node node4 = new Node(4);
        Node node10 = new Node(10);
        Node node8 = new Node(8);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        root.setLeft(node4);
        root.setRight(node10);
        node4.setLeft(node8);
        node4.setRight(node5);
        node10.setLeft(node2);
        node10.setRight(node1);
        zigzagLevelOrderTraversal1(root);
//        System.out.println();
//        zigzagLevelOrderTraversal2(root);

    }

    // Using 2 stacks
    private static void zigzagLevelOrderTraversal1(Node root) {
        Stack<Node> currentLevel = new Stack<>();
        currentLevel.push(root);
        boolean moveLeft = true;
        Stack<Node> nextLevel = new Stack<>();
        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                Node node = currentLevel.pop();
                System.out.print(node.getData() + "\t");
                if (moveLeft) {
                    if (node.getLeft() != null) {
                        nextLevel.push(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        nextLevel.push(node.getRight());
                    }
                } else {
                    if (node.getRight() != null) {
                        nextLevel.push(node.getRight());
                    }
                    if (node.getLeft() != null) {
                        nextLevel.push(node.getLeft());
                    }
                }
            }
            Stack<Node> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            moveLeft = !moveLeft;
        }
    }

    // Using queue
//    private static void zigzagLevelOrderTraversal2(Node root) {
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        queue.add(null);
//        boolean moveLeft = false;
//        while (!queue.isEmpty()) {
//            Node node = queue.remove();
//            if (node != null) {
//                System.out.print(node.getData()+"\t");
//                if (moveLeft) {
//                    insertLeftNode(queue, node);
//                    insertRightNode(queue, node);
//                } else {
//                    insertRightNode(queue, node);
//                    insertLeftNode(queue, node);
//                }
//            } else {
//                if (!queue.isEmpty()) {
//                    queue.add(null);
//                    moveLeft = !moveLeft;
//                }
//
//            }
//        }
//    }
//
//    private static void insertLeftNode(Queue<Node> queue, Node node) {
//        if (node.getLeft() != null) {
//            queue.add(node.getLeft());
//        }
//    }
//
//    private static void insertRightNode(Queue<Node> queue, Node node) {
//        if (node.getRight() != null) {
//            queue.add(node.getRight());
//        }
//    }
}
