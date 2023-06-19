package com.algo.tree.bst;

import com.algo.tree.Node;

import java.util.Stack;

public class KSmallest {

    public static void main(String[] args) {

        Node root = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.setRight(node6);
        root.setLeft(node2);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setRight(node7);
        node6.setLeft(node5);
        System.out.println("3th smallest element in tree = " + kthSmallestElement(root, 3).getData());
        System.out.println("3th smallest element in tree = " + kThSmallestUsingStack(root, 3));
        System.out.println("4th largest element in tree = " + kthLargestElement1(root, 4).getData());
        System.out.println("2nd largest element in tree = " + kthLargestElement2(root, 2).getData());


    }

    //Kth the largest node is (n-k+1)th the smallest node in inorder traversal of bst
    private static Node kthLargestElement1(Node root, int k) {
        Counter counter = new Counter();
        return kthSmallestElement(root, counter, countNodes(root) - k + 1);
    }

    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;
    }

    //Leetcode accepted solution
    private static Node kthSmallestElement(Node root, int k) {
        Counter counter = new Counter();
        return kthSmallestElement(root, counter, k);
    }

    private static Node kthSmallestElement(Node root, Counter counter, int k) {

        if (root == null) {
            return null;
        }
        Node node = kthSmallestElement(root.getLeft(), counter, k);
        //if left node is not null that means its kth the smallest element
        if (node != null) {
            return node;
        }
        counter.k++;
        if (counter.k == k) {
            return root;
        }
        return kthSmallestElement(root.getRight(), counter, k);


    }


    public static int kThSmallestUsingStack(Node root, int k) {
        if (root == null) {
            return -99999;
        }
        Node current = root;
        int kthSmallest;
        Stack<Node> stack = new Stack<>();
        while (true) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();

            } else {
                Node node = stack.pop();
                --k;
                if (k == 0) {
                    kthSmallest = node.getData();
                    break;
                }
                current = node.getRight();


            }

        }
        return kthSmallest;
    }

    private static Node kthLargestElement2(Node root, int k) {
        Counter counter = new Counter();
        return kthLargestElement2(root, k, counter);
    }

    private static Node kthLargestElement2(Node root, int k, Counter counter) {
        if (root == null) {
            return null;
        }
        Node right = kthLargestElement2(root.getRight(), k, counter);
        if (right != null) {
            return right;
        }
        counter.k++;
        if (counter.k == k) {
            return root;
        }
        return kthLargestElement2(root.getLeft(), k, counter);
    }

    private static class Counter {
        private int k;

        private Counter() {
            this.k = 0;
        }
    }
}
