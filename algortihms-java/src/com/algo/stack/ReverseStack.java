package com.algo.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        //Original order of stack 5 4 3 2 1
        System.out.println("Reversed stack");
        printStack(stack);

    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int item = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, item);
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }

    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }
}
