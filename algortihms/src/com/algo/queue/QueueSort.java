package com.algo.queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueSort {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(29);
        queue.add(10);
        queue.add(3);
        queue.add(8);
        queue.add(1);
        queue.add(7);
        queue = sort(queue);
        for (int element : queue) {
            System.out.print(element + "\t");
        }


    }

    private static Queue<Integer> sort(Queue<Integer> queue) {
        Queue<Integer> sortedQueue = new LinkedList<>();
        //Queue<Integer> tempQueue=new LinkedList<>();
        int minElement = Integer.MAX_VALUE;
        int counter = 0;
        while (!queue.isEmpty()) {
            int element = queue.remove();
            if (!sortedQueue.isEmpty()) {
                while (!sortedQueue.isEmpty()) {

                    if (sortedQueue.peek() > element) {
                        sortedQueue.add(sortedQueue.remove());
                    } else {
                        queue.add(sortedQueue.remove());
                    }
                }
                sortedQueue.add(element);

            } else {
                sortedQueue.add(element);
            }
        }
        return sortedQueue;
    }


}
