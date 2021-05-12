package com.algo.stack;

import java.util.Stack;

public class StackQueue {
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

    }

    private static class Queue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public Queue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void enqueue(int item) {
            stack1.push(item);
        }

        public int dequeue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("Queue is empty");
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
