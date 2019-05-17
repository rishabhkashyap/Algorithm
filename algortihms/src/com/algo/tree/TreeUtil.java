package com.algo.tree;

public class TreeUtil {

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getData() + "\t");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }

    }


    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + "\t");
            inOrder(root.getRight());
        }

    }


}
