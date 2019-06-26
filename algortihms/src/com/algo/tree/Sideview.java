package com.algo.tree;

public class Sideview {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        System.out.println("Left view of tree");
        printLeftView(root);
        System.out.println("\n\nRight view of tree");
        printRightView(root);

    }

    private static void printLeftView(Node root) {
        Height height = new Height();
        leftViewHelper(root, height, 1);
    }

    private static void leftViewHelper(Node root, Height height, int level) {
        if (root == null) {
            return;
        }
        if (height.maxHeight < level) {
            System.out.print(root.getData() + "\t");
            height.maxHeight = level;

        }
        leftViewHelper(root.getLeft(), height, level + 1);
        leftViewHelper(root.getRight(), height, level + 1);

    }


    private static void printRightView(Node root) {
        Height height = new Height();
        rightViewHelper(root, height, 1);
    }

    private static void rightViewHelper(Node root, Height height, int level) {
        if (root == null) {
            return;
        }
        if (height.maxHeight < level) {
            System.out.print(root.getData() + "\t");
            height.maxHeight = level;

        }
        rightViewHelper(root.getRight(), height, level + 1);
        rightViewHelper(root.getLeft(), height, level + 1);


    }

    private static class Height {
        private int maxHeight;
    }
}
