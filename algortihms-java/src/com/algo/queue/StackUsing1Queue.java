package com.algo.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Popped item = " + stack.pop());
        System.out.println("Top item = " + stack.peek());
        System.out.println("Popped item = " + stack.pop());
        System.out.println("Top item = " + stack.peek());

    }

    private static class Stack {

        private Queue<Integer> queue;
        private int size;
        private int capacity;

        private Stack(int capacity) {
            this.capacity = capacity;
            this.queue = new LinkedList<>();
            this.size = 0;
        }

        private void push(int item) {
            if (size == capacity) {
                throw new RuntimeException("Stack is full");
            }
            queue.add(item);
            ++size;
            int i = 0;
            while (i < size - 1) {
                queue.add(queue.remove());
                ++i;
            }
        }

        private Integer pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            --size;
            return queue.remove();
        }

        private Integer peek() {
            if (size == 0) {
                return null;
            }
            return queue.peek();
        }

    }
}
