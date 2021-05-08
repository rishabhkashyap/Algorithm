package com.algo.tree.traversal;

import com.algo.tree.Node;

import java.util.Stack;

public class PostOrderTraversal {
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
        node3.setLeft(node6);
        postOrder1(node1);
        System.out.println("\n");
        postOrder2(node1);
        System.out.println("\n");
        postOrder3(node1);
    }

    private static void postOrder1(Node root) {
        if (root == null) {
            return;
        }
        postOrder1(root.getLeft());
        postOrder1(root.getRight());
        System.out.print(root.getData() + "\t");
    }

    //Iterative traversal using 2 stacks
    private static void postOrder2(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be null");
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + "\t");
        }

    }

    //Iterative postorder traversal using 1 stack
    //1.Check if right child exist
    //2.if it exist, push to stack
    //3.push root to stack
    //4.pop element from stack
    //5.check if new top element of stack is right child of recently popped element
    //6.if yes pop it push root node in stack and set root to its right child
    //7.if right child in not new top element in stack then print it and set root to null
    private static void postOrder3(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Root of tree cannot be null");
        }
        Stack<Node> stack = new Stack<>();
        do {
            while (root != null) {
                if (root.getRight() != null) {
                    stack.push(root.getRight());
                }
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            if (!stack.isEmpty() && root.getRight() == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.getRight();
            } else {
                System.out.print(root.getData() + "\t");
                root = null;
            }

        } while (!stack.isEmpty());


    }
}
