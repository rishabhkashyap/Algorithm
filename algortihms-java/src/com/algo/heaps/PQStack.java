package com.algo.heaps;

import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(9);
        System.out.println("Item at top = "+stack.peek());
        System.out.println(stack.pop());

    }

    private static class Stack {
        private Queue<Element> queue;
        private int index;

        public Stack() {
            this.queue = new PriorityQueue<>((e1, e2) -> e2.getIndex() - e1.getIndex());
            this.index = 0;
        }

        public void push(int item) {
            queue.add(new Element(item, index++));
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new EmptyStackException();
            }
            --this.index;
            return queue.remove().getValue();
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new EmptyStackException();
            }
            return queue.peek().getValue();


        }

        public int size() {
            return queue.size();
        }
    }

    private static class Element {
        private int value;
        private int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}

