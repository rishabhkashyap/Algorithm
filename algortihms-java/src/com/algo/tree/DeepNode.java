package com.algo.tree;

public class DeepNode {

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node22 = new Node(22);
        Node node23 = new Node(23);
        root.setRight(node2);
        root.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(node22);
        node22.setLeft(node23);
        node23.setRight(new Node(35));
        int height = getHeight(root);
        findDeepestNode(root, height);
        //System.out.println("Deepest node in tree = " + deepestNode.getData());

    }

    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static void findDeepestNode(Node root, int height) {

        if (root != null) {
            if (height == 1) {
                System.out.println(root.getData());
            } else if (height > 1) {
                findDeepestNode(root.getLeft(), --height);
                findDeepestNode(root.getRight(), height);
            }
        }
    }
}
