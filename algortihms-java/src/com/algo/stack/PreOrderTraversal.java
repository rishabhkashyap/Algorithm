package com.algo.stack;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        int[] preorder1 = {4, 2, 1, 3, 6, 5, 7};
        int[] preorder2 = {2, 4, 1};

        System.out.println("Array  represnts preorder traversal of BST = " + isPreorderRepresentation(preorder1));
        System.out.println("Array  represnts preorder traversal of BST = " + isPreorderRepresentation(preorder2));

    }

    private static boolean isPreorderRepresentation(int[] preorder) {
        Stack<Integer> preorderStack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (root > preorder[i]) {
                return false;
            }
            while (!preorderStack.isEmpty() && preorderStack.peek() < preorder[i]) {
                root = preorderStack.pop();

            }
            preorderStack.push(preorder[i]);
        }
        return true;
    }

}
