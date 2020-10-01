package com.algo.stack;

import java.util.Stack;

public class StackQueue2 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        System.out.println("Top element = " + queue.peek());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Removed element = " + queue.dequeue());
        System.out.println("Removed element = " + queue.dequeue());
        System.out.println("Top element = " + queue.peek());
    }

    private static class Queue {
        private Stack<Integer> stack;

        public Queue() {
            this.stack = new Stack<>();
        }

        public void enqueue(int item) {
            if (stack.isEmpty()) {
                stack.push(item);
                return;
            }
            int temp = stack.pop();
            enqueue(item);
            stack.push(temp);
        }

        public int dequeue() {
            if (!stack.isEmpty()) {
                return stack.pop();
            }
            return -1;
        }

        public int peek() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

    }
}
