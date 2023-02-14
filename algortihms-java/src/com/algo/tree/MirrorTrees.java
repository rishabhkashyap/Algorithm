package com.algo.tree;

public class MirrorTrees {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        System.out.println("Original Tree");
        TreeUtil.preOrder(root);
        flipTree1(root);
        //flipTree3(root);
        System.out.println("\nFlipped tree");
        TreeUtil.preOrder(root);
//        root = flipTree2(root);
//        System.out.println("\nFlipped tree");
//        TreeUtil.preOrder(root);
    }

    //Flip Tree
    private static void flipTree1(Node root) {
        Node temp;
        if (root != null) {
            flipTree1(root.getLeft());
            flipTree1(root.getRight());
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
    }

    private static Node flipTree2(Node root) {
        if (root == null) {
            return null;
        }
        root.setLeft(flipTree2(root.getLeft()));
        root.setRight(flipTree2(root.getRight()));
        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        return root;
    }

    public static Node flipTree3(Node root) {
        if (root == null) {
            return null;
        }
        flipTree3(root.getLeft());
        flipTree3(root.getRight());
        Node temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);
        return root;

    }


}
