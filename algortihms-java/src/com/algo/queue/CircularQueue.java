package com.algo.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.display();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.display();
        System.out.println("Dequeued element = " + queue.dequeue());
        queue.enqueue(15);
        queue.display();
        System.out.println("Dequeued element = " + queue.dequeue());
        System.out.println("Dequeued element = " + queue.dequeue());
        System.out.println("Peek of queue = " + queue.peek());
    }

    static class Queue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public Queue(int capacity) {

            queue = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        public void enqueue(int element) {
            if (isFull()) {
                throw new IllegalStateException("Queue is full");
            } else {

                rear = (rear + 1) % queue.length;
                queue[rear] = element;
                ++size;
                if (front == -1) {
                    front = rear;
                }
            }
        }


        private boolean isFull() {
            return size == queue.length;
        }


        public int dequeue() {
            int element = 0;
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            } else {
                element = queue[front];
                front = (front + 1) % queue.length;
                --size;

            }
            return element;
        }

        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return queue[front];
        }

        private boolean isEmpty() {
            return size == 0;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                Arrays.stream(queue)
                        .forEach(e -> System.out.print(e + "\t"));
                System.out.println();
            }
        }
    }


}



