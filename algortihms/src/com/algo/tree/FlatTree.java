package com.algo.tree;

import java.util.Stack;

public class FlatTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.setLeft(node2);
        root.setRight(node5);
        node2.setLeft(node3);
        node2.setRight(node4);
        node5.setRight(node6);
        //flattenTreeIterative(root);
        flattenTreeRecursive(root);
        print(root);
    }

    public static void flattenTreeIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                current.setRight(current.getLeft());
                current.setLeft(null);
            } else if (!stack.isEmpty()) {
                Node node = stack.pop();
                current.setRight(node);
            }
            current = current.getRight();
        }

    }

    public static void flattenTreeRecursive(Node root) {
        if(root==null||(root.getRight()==null && root.getLeft()==null)){
            return;
        }
        if(root.getLeft()!=null){
            flattenTreeRecursive(root.getLeft());
            Node temp=root.getRight();
            root.setRight(root.getLeft());
            root.setLeft(null);
            Node current =root;
            while (current.getRight()!=null){
                current=current.getRight();

            }
            current.setRight(temp);
        }
        flattenTreeRecursive(root.getRight());
    }



    public static void print(Node root) {
        Node current = root;
        System.out.println();
        while (current != null) {
            System.out.print(current.getData() + "\t");
            current = current.getRight();
        }
        System.out.println();
    }
}
