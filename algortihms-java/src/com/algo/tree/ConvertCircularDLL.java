package com.algo.tree;

public class ConvertCircularDLL {

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
        node2.setRight(new Node(22));

        Node head = convertToCircularLinkedList(root);
        printCircularList(head);


    }

    private static Node convertToCircularLinkedList(Node root) {
        if (root == null) {
            return null;
        }

        Node left = convertToCircularLinkedList(root.getLeft());
        Node right = convertToCircularLinkedList(root.getRight());
        root.setLeft(root);
        root.setRight(root);

        return concatenate(concatenate(left, root), right);
    }

    private static Node concatenate(Node leftList, Node rightList) {

        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        Node leftLast = leftList.getLeft();
        Node rightLast = rightList.getLeft();

        leftLast.setRight(rightList);
        rightList.setLeft(leftLast);

        leftList.setLeft(rightLast);
        rightLast.setRight(leftList);

        return leftList;

    }

    private static void printCircularList(Node head) {
        if (head != null) {

            Node current = head;
            while (current.getRight() != head) {
                System.out.print(current.getData() + "  ->  ");
                current = current.getRight();
            }
            System.out.print(current.getData() + "  ->  ");
        }
    }
}
