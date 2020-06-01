package com.algo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathRevisit {

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
        node7.setRight(new Node(22));
        printPaths(root);
    }

    private static void printPaths(Node root) {
        Node[] path = new Node[100];
        calculatePath(root, 0,path);
    }

    private static void calculatePath(Node root,int index ,Node[] path) {
        if (root == null) {
            return;
        } else {
            path[index++]=root;
            if (root.getLeft() == null && root.getRight() == null) {
                System.out.println();
                Arrays.stream(path,0,index)
                        .forEach(e -> System.out.print(e.getData() + "\t"));

            }
            calculatePath(root.getLeft(),index, path);
            calculatePath(root.getRight(), index,path);

        }
    }
}
