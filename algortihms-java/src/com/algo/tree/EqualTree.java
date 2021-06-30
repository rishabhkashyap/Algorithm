package com.algo.tree;

public class EqualTree {
    public static void main(String[] args) {
        Node root1 = new Node(10);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root1.setRight(node2);
        root1.setLeft(node8);
        node8.setLeft(node3);
        node8.setRight(node5);
        node2.setLeft(node7);
        node7.setRight(new Node(22));

        Node root2 = new Node(10);
        Node node28 = new Node(8);
        Node node22 = new Node(2);
        Node node23 = new Node(3);
        Node node25 = new Node(5);
        Node node27 = new Node(7);
        root2.setRight(node22);
        root2.setLeft(node28);
        node28.setLeft(node23);
        node28.setRight(node25);
        node22.setLeft(node27);
        node27.setRight(new Node(22));
        System.out.println("Trees are identical = " + equals(root1, root2));

    }

    private static boolean equals(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean left = equals(root1.getLeft(), root2.getLeft());
        boolean right = equals(root1.getRight(), root2.getRight());
        return (root1.getData() == root2.getData()) && left && right;
    }
}
