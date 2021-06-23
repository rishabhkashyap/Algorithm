package com.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(34);
//        stack.push(3);
//        stack.push(31);
//        stack.push(98);
//        stack.push(92);
//        stack.push(23);
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(5, -2, 9, -7, 3));
        Stack<Integer> result = sort1(stack);
        printStack(result);
//        sort2(stack);
//        printStack(stack);


    }

    //Iterative approach
    private static Stack<Integer> sort1(Stack<Integer> stack) {
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

    //Using recursion
    private static void sort2(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sort2(stack);
        sort2(stack, temp);

    }

    private static void sort2(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() > element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        sort2(stack, element);
        stack.push(temp);

    }

    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }
}
