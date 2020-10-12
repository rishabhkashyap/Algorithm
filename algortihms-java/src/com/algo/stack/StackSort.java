package com.algo.stack;

import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        Stack<Integer> result = sort(stack);
        printStack(result);

    }

    private static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int element = stack.pop();
            while (!temp.isEmpty() && temp.peek() < element) {
                stack.push(temp.pop());
            }
            temp.push(element);
        }
        return temp;
    }

    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }
}
