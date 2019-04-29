package com.algo.tree;

public class TreeDiameter2 {

    public static void main(String[] arg) {
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


        int diameter = getDiameter(root);
        System.out.println("Diameter of tree = " + diameter);
    }

    private static int getDiameter(Node root) {

        TreeHeight treeHeight = new TreeHeight();
        return calculateDiameter(root, treeHeight);

    }

    private static int calculateDiameter(Node root, TreeHeight treeHeight) {
        TreeHeight lTreeHeight = new TreeHeight();
        TreeHeight rTreeHeight = new TreeHeight();
        if (root == null) {
            //Set height as 0
            treeHeight.height = 0;
            //Set diameter as 0
            return 0;
        }
        int lDiameter = calculateDiameter(root.getLeft(), lTreeHeight);
        int rDiameter = calculateDiameter(root.getRight(), rTreeHeight);
        treeHeight.height = 1 + Math.max(lTreeHeight.height, rTreeHeight.height);
        return Math.max(lTreeHeight.height + rTreeHeight.height + 1, Math.max(lDiameter, rDiameter));

    }

    private static class TreeHeight {
        private int height;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
