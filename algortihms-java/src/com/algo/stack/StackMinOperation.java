package com.algo.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackMinOperation {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(8);
        minStack.push(9);
        minStack.push(1);
        minStack.push(2);
        minStack.push(10);
        minStack.push(15);
        System.out.println("Min value in stack = " + minStack.getMinimumValue());
        System.out.println("Popped element = "+minStack.pop());
        System.out.println("Min value in stack = " + minStack.getMinimumValue());
        System.out.println("Popped element = "+minStack.pop());
        System.out.println("Popped element = "+minStack.pop());
        System.out.println("Popped element = "+minStack.pop());
        System.out.println("Min value in stack = " + minStack.getMinimumValue());

    }

    private static class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int element) {
            dataStack.push(element);
            if (minStack.isEmpty() || minStack.peek() > element) {
                minStack.push(element);
            }
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new EmptyStackException();
            }
            if (dataStack.peek() == minStack.peek()) {
                minStack.pop();
            }
            return dataStack.pop();
        }

        public int getMinimumValue() {
            if (dataStack.isEmpty()) {
                throw new EmptyStackException();
            }
            return minStack.peek();

        }
    }
}

