package com.algo.stack;

import java.util.Stack;

//Problem: https://leetcode.com/problems/min-stack/

public class MinStack155 {
    public static void main(String[] args) {
    }

    private static class MinStack {

        private Stack<Integer> data;

        private Stack<Integer> minStack;

        public MinStack() {
            this.data = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public int pop() {
            if (data.isEmpty()) {
                return -1;
            }
            var value = data.pop();
            if (value == minStack.peek()) {
                minStack.pop();
            }
            return value;
        }

        public int top() {
            if (data.isEmpty()) {
                return -1;
            }
            return data.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }
}
