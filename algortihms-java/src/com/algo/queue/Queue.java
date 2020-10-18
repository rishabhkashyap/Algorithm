package com.algo.queue;

import java.util.Arrays;

public class Queue {

    public static void main(String[] args) {

        QueueArray queueArray = new QueueArray(5);
        queueArray.display();
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        //queueArray.enqueue(5);
        queueArray.display();
        System.out.println("Dequeued element = " + queueArray.dequeue());
        queueArray.enqueue(10);
        queueArray.display();


    }


    static class QueueArray {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public QueueArray(int capacity) {
            queue = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int element) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                ++size;
                queue[++rear] = element;
            }
        }

        public int dequeue() {
            int element = -9999;
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                element = queue[front];
                ++front;
                --size;
            }
            return element;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private boolean isFull() {
            return size == queue.length;
        }


        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty... nothing to show");
            } else {
                System.out.println();

                Arrays.stream(queue, front, rear + 1).forEach(e -> System.out.print(e + "\t"));
                System.out.println("\n");
            }
        }


    }
}
