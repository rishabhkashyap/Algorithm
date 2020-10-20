package com.algo.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
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
        stack.push(10);
        System.out.println("Popped item = " + stack.pop());

    }

    private static class Stack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int size;
        private int capacity;

        public Stack(int capacity) {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            size = 0;
            this.capacity = capacity;
        }

        public void push(int item) {
            if (size == capacity) {
                throw new RuntimeException("Stack full");
            }
            queue1.add(item);
            ++size;
        }

        public int pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }
            int item = queue1.remove();
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            --size;
            return item;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            while (queue1.size() != 1) {
                queue2.add(queue1.remove());
            }
            int item = queue1.peek();
            queue2.add(queue1.remove());
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return item;

        }

        public int getSize() {
            return this.size;
        }


    }
}
