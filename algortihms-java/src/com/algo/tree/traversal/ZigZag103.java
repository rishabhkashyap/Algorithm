package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class ZigZag103 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.setRight(node3);
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setRight(new Node(10));
        node4.setLeft(new Node(21));
        List<List<Integer>> result = zigzagTraversal(root);
        System.out.println(result);
        result = zigzagTraversal2(root);
        System.out.println(result);
        performZigzagTraversal(root);
    }

    //Do BFS and at every odd level add node in reverse order, this approach will save time spent
    // on reversing the levelNode list at the end of each level traversal
    private static List<List<Integer>> zigzagTraversal(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        var isEvenLevel = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            while (size-- > 0) {
                var node = queue.remove();
                if (isEvenLevel) {
                    levelNodes.addLast(node.getData());
                } else {
                    levelNodes.addFirst(node.getData());
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            isEvenLevel = !isEvenLevel;
            result.add(levelNodes);
        }
        return result;
    }

    // Do BFS and at every odd level reverse the list and add it to the result
    private static List<List<Integer>> zigzagTraversal2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        var isEvenLevel = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            while (size-- > 0) {
                var node = queue.remove();
                levelNodes.add(node.getData());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            if (!isEvenLevel) {
                Collections.reverse(levelNodes);
                result.add(levelNodes);
            } else {
                result.add(levelNodes);
            }
            isEvenLevel = !isEvenLevel;
        }
        return result;
    }

    private static void performZigzagTraversal(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        }
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            System.out.print(node.getData() + "\t");
            if (leftToRight) {
                insertLeftChild(nextLevel, node);
                insertRightChild(nextLevel, node);

            } else {
                insertRightChild(nextLevel, node);
                insertLeftChild(nextLevel, node);
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;

            }
        }

    }

    private static void insertLeftChild(Stack<Node> stack, Node root) {
        if (root.getLeft() != null) {
            stack.push(root.getLeft());
        }
    }

    private static void insertRightChild(Stack<Node> stack, Node root) {
        if (root.getRight() != null) {
            stack.push(root.getRight());
        }
    }
}
