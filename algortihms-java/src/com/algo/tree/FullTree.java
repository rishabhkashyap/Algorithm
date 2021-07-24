package com.algo.tree;

public class FullTree {

    public static void main(String[] args) {

        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node2.setRight(new Node(22));
        System.out.println("Tree is a full tree = " + isTreeFull(root));


    }

    private static boolean isTreeFull(Node root) {
        if (root == null) {
            return true;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }

        if (root.getLeft() != null && root.getRight() != null) {
            boolean isLeftFull = isTreeFull(root.getLeft());
            boolean isRightFull = isTreeFull(root.getRight());
            return isLeftFull && isRightFull;
        }
        return false;

    }


}
