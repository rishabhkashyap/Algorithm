package com.algo.tree.bst;

import com.algo.tree.Node;
import com.algo.tree.TreeUtil;

//Update every key in bst to contain sum of all greater keys
public class GreaterKeySum {

    public static void main(String[] args) {
        Node root = new Node(5);
        Node node3 = new Node(3);
        Node node8 = new Node(8);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node10 = new Node(10);
        root.setLeft(node3);
        root.setRight(node8);
        node3.setLeft(node2);
        node3.setRight(node4);
        node8.setLeft(node6);
        node8.setRight(node10);
        updateKeys(root);
        TreeUtil.preOrder(root);
    }

    private static void updateKeys(Node root) {
        Sum sum = new Sum();
        updateKeysToSum(root, sum);
    }

    private static int updateKeysToSum(Node root, Sum sum) {
        if (root == null) {
            return sum.value;
        }
        int right = updateKeysToSum(root.getRight(), sum);
        root.setData(root.getData() + right);
        sum.value = root.getData();
        return updateKeysToSum(root.getLeft(), sum);
    }

    private static class Sum {
        private int value;

    }

}
