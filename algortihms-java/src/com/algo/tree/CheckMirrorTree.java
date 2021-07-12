package com.algo.tree;

public class CheckMirrorTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node4 = new Node(4);

        root.setLeft(node3);
        root.setRight(node2);
        node2.setLeft(node5);
        node2.setRight(node4);

        Node rootMirror = new Node(1);
        Node nodeMirror2 = new Node(2);
        Node nodeMirror3 = new Node(3);
        Node nodeMirror4 = new Node(4);
        Node nodeMirror5 = new Node(5);

        rootMirror.setLeft(nodeMirror2);
        rootMirror.setRight(nodeMirror3);
        nodeMirror2.setLeft(nodeMirror4);
        nodeMirror2.setRight(nodeMirror5);

        System.out.println("Trees are mirror = " + isMirror(root, rootMirror));

    }

    private static boolean isMirror(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getData() == root2.getData()) {
            return (isMirror(root1.getLeft(), root2.getRight())
                    && isMirror(root1.getRight(), root2.getLeft()));
        }
        return false;
    }

}
