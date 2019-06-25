package com.algo.tree.bst;

import com.algo.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {

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
        System.out.println("Pair exist for 14 = " + isPairForSumExist(root, 14));

    }

    private static boolean isPairForSumExist(Node root, int target) {
        boolean pairExist = false;

        if (root == null) {
            return false;
        }
        List<Integer> inOrderList = toList(root);
        int start = 0;
        int end = inOrderList.size() - 1;
        while (start <= end) {
            if (inOrderList.get(start) + inOrderList.get(end) == target) {
                pairExist = true;
                break;
            } else if (inOrderList.get(start) + inOrderList.get(end) < target) {
                ++start;
            } else if (inOrderList.get(start) + inOrderList.get(end) > target) {
                --end;
            }
        }
        return pairExist;
    }

    private static List<Integer> toList(Node root) {
        List<Integer> inOrderList = new ArrayList<>();
        toListHelper(root, inOrderList);
        return inOrderList;
    }

    private static void toListHelper(Node root, List<Integer> inOrderList) {
        if (root != null) {
            toListHelper(root.getLeft(), inOrderList);
            inOrderList.add(root.getData());
            toListHelper(root.getRight(), inOrderList);
        }
    }
}
