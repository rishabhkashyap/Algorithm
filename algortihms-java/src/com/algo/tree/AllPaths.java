package com.algo.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AllPaths {

    static void main() {
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
        findPaths(root);
        System.out.println("\nPath to 23 exists = " + hasPath1(root, 23));
        System.out.println("\nPath to 23 exists = " + hasPath2(root, 23));

    }

    public static void findPaths(Node root) {
        int[] path = new int[100];
        LinkedList<int[]> paths = new LinkedList<>();
        findPaths(root, path, 0, paths);
        System.out.println("Stored paths");
        paths.forEach(
                p -> {
                    Arrays.stream(p).forEach(e -> System.out.print(e + "\t"));
                    System.out.println();
                }
        );
    }

    public static void findPaths(Node root, int[] path, int len, LinkedList<int[]> paths) {
        if (root == null) {
            return;
        }
        path[len++] = root.getData();
        if (root.getLeft() == null && root.getRight() == null) {
            paths.add(Arrays.copyOfRange(path, 0, len));
        } else {
            findPaths(root.getLeft(), path, len, paths);
            findPaths(root.getRight(), path, len, paths);
        }
    }


    //Method return true if there exists a path whose sum is equal to given number
    public static boolean hasPath1(Node root, int sum) {
        if (root == null)
            return false;
        if (root.getLeft() == null && root.getRight() == null && root.getData() == sum) {
            return true;
        }
        return (hasPath1(root.getLeft(), sum - root.getData()) || hasPath1(root.getRight(), sum - root.getData()));
    }

    //Iterative method that return true if there exists a path whose sum is equal to given number
    private static boolean hasPath2(Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<SumPath> stack = new Stack<>();
        stack.push(new SumPath(root, root.getData()));
        while (!stack.isEmpty()) {
            var sumPath = stack.pop();
            var node = sumPath.node;
            var sum = sumPath.sum;
            if (node.getLeft() == null && node.getRight() == null && sum == targetSum) {
                return true;
            }
            if (node.getLeft() != null) {
                stack.push(new SumPath(node.getLeft(), sum + node.getLeft().getData()));
            }
            if (node.getRight() != null) {
                stack.push(new SumPath(node.getRight(), sum + node.getRight().getData()));
            }
        }
        return false;
    }

    private record SumPath(Node node, int sum){}

}
