package com.algo.tree.bst;

import com.algo.tree.Node;

public class K1K2Range {
    public static void main(String[] args){
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
        int k1=3;;
        int k2=7;
        printInRange(root,k1,k2);
    }

    private static void printInRange(Node root, int k1, int k2) {
        if(root==null){
            return;
        }
        printInRange(root.getLeft(),k1,k2);
        if(root.getData()>k1 && root.getData()<k2){
            System.out.print(root.getData()+"\t");
        }
        printInRange(root.getRight(),k1,k2);
    }
}
