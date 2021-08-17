package com.algo.tree.bst;

import com.algo.tree.Node;

public class DLLToBST {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 7; i >= 1; --i) {
            if (head == null) {
                head = new Node(i);
            } else {
                Node node = new Node(i);
                node.setRight(head);
                head.setLeft(node);
                head = node;
            }
        }
        // printList(head);
        Node root = convertToBST(head);
        traversal(root);


    }

    private static Node convertToBST(Node head) {
        int len = len(head);
        //System.out.println(len);
        return convertToBST(head, len);
    }

    private static Node convertToBST(Node head, int len) {
        if (len <= 0) {
            return null;
        }
        Node left = convertToBST(head, len / 2);
        Node root = head;
        head = head.getLeft();
        root.setLeft(left);
        root.setRight(convertToBST(head, len - len / 2 - 1));
        return root;
    }

    private static int len(Node head) {
        int count = 0;
        while (head != null) {
            ++count;
            head = head.getRight();
        }
        return count;
    }

    private static void printList(Node head) {
        Node temp = head;
        Node tail = null;
        System.out.println("Traversing from head");
        while (temp != null) {
            tail = temp;
            System.out.print(temp.getData() + "\t");
            temp = temp.getRight();
        }
        System.out.println("\nTraversing from tail");
        while (tail != null) {
            System.out.print(tail.getData() + "\t");
            tail = tail.getLeft();
        }
    }

    private static void traversal(Node root) {
        if (root == null) {
            return;
        }
        traversal(root.getLeft());
        System.out.print(root.getData() + "\t");
        traversal(root.getLeft());
    }
}
