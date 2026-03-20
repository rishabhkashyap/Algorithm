package com.algo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

//Problem:https://leetcode.com/problems/merge-two-binary-trees/description/

public class MergeTree617 {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        root1.setLeft(node3);
        root1.setRight(node2);
        node3.setLeft(node5);
        Node root2 = new Node(2);
        Node node1 = new Node(1);
        Node node33 = new Node(3);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        root2.setLeft(node1);
        root2.setRight(node33);
        node1.setRight(node4);
        node33.setRight(node7);
        Node root =merge1(root1,root2);
        TreeUtil.inOrder(root);
        root=merge2(root1,root2);
        System.out.println();
        TreeUtil.inOrder(root);
    }

    private static Node merge1(Node root1, Node root2){
        if(root1==null && root2 ==null){
            return null;
        }
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        Node node = new Node(root1.getData()+ root2.getData());
        node.setLeft(merge1(root1.getLeft(),root2.getLeft()));
        node.setRight(merge1(root1.getRight(),root2.getRight()));
        return node;
    }
    private static Node merge2(Node root1, Node root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //Using deque as stack for better performance.
        Deque<NodePair> stack = new ArrayDeque<>();
        stack.push(new NodePair(root1, root2));
        while (!stack.isEmpty()) {
            var pair = stack.pop();
            if (pair.node2 == null) {
                continue;
            }
            pair.node1.setData(pair.node1.getData() + pair.node2.getData());
            if (pair.node1.getLeft() == null) {
                pair.node1.setLeft(pair.node2.getLeft());
            } else {
                stack.push(new NodePair(pair.node1.getLeft(), pair.node2.getLeft()));
            }
            if (pair.node1.getRight() == null) {
                pair.node1.setRight(pair.node2.getRight());
            } else {
                stack.push(new NodePair(pair.node1.getRight(), pair.node2.getRight()));
            }
        }
        return root1;
    }
    private record NodePair(Node node1, Node node2){}
}
