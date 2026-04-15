package com.algo.tree.bst;

import com.algo.tree.Node;

import java.util.Stack;

public class KSmallest {

    static void main() {

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
        System.out.println("2nd largest element in tree = " + kthLargestElement2(root, 2).getData());
    }



    //Leetcode accepted solution
    //Worst case time complexity O(N)
    //Average time complexityO(H + K). Code goes to the extreme left to find the smallest number which will require
    //traversal equivalent to height(H) of tree and then k traversal are needed to find kth smallest element.
    //Space complexity: O(log N)
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

    //Worst case time complexity O(N)
    //Average time complexityO(H + K). Code goes to the extreme left to find the smallest number which will require
    //traversal equivalent to height(H) of tree and then k traversal are needed to find kth smallest element.
    //Space complexity: O(log N)
    public static int kThSmallestUsingStack(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                --k;
                if (k == 0) {
                    return node.getData();
                }
                current = node.getRight();
            } else {
                break;
            }
        }
        return -1;
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
