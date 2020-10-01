package com.algo.stack;

import java.util.Stack;

public class StackQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        System.out.println("Top element = " + queue.peek());
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Removed element = " + queue.remove());
        System.out.println("Removed element = " + queue.remove());

    }

    private static class Queue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void add(int item) {
            stack1.push(item);
        }

        public int remove() {
            if (stack1.isEmpty()) {
                return -1;
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();


        }

    }
}
