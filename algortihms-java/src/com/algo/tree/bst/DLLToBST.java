package com.algo.tree.bst;

import com.algo.tree.Node;

public class DLLToBST {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.createdSortedDLL(7);
        Node root = dll.convertToBST();
        traversal(root);


    }


    private static void traversal(Node root) {
        if (root == null) {
            return;
        }
        traversal(root.getLeft());
        System.out.print(root.getData() + "\t");
        traversal(root.getLeft());
    }

    private static class DLL {
        private Node head;

        public Node createdSortedDLL(int n) {
            for (int i = n; i >= 1; --i) {
                Node node = new Node(i);
                insertArFront(node);
            }

            return head;

        }

        private void insertArFront(Node node) {
            if (head == null) {
                this.head = node;
            } else {

                node.setRight(head);
                head.setLeft(node);
                head = node;
            }


        }

        public void printList() {
            Node temp = head;
            Node tail = null;
            System.out.println("Traversing from head");
            while (temp != null) {
                tail = temp;
                System.out.print(temp.getData() + "\t");
                temp = temp.getRight();
            }
            System.out.println("\nTraversing from tail");
            while (tail != null) {
                System.out.print(tail.getData() + "\t");
                tail = tail.getLeft();
            }
        }

        public Node convertToBST() {
            int len = len();
            return convertToBST(len);
        }

        private int len() {
            Node temp=head;
            int count = 0;
            while (temp != null) {
                ++count;
                temp = temp.getRight();
            }
            return count;
        }

        private Node convertToBST(int len) {
            if (len <= 0) {
                return null;
            }
            Node left = convertToBST(len / 2);
            Node root = head;
            root.setLeft(left);
            head = head.getRight();
            root.setRight(convertToBST(len - len / 2 - 1));
            return root;
        }


    }
}
