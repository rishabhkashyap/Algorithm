package com.algo.queue;


import java.util.LinkedList;
import java.util.Queue;

public class QueueSort {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
//        queue.add(5);
//        queue.add(29);
//        queue.add(10);
//        queue.add(3);
//        queue.add(8);
//        queue.add(1);
//        queue.add(7);

        queue.add(11);
        queue.add(5);
        queue.add(4);
        queue.add(21);
        queue = sort(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + "\t");
        }


    }

    private static Queue<Integer> sort(Queue<Integer> queue) {
        for (int i = 1; i <= queue.size(); i++) {
            int minIndex = findMinIndex(queue, queue.size() - i);
            insert(queue, minIndex);
        }
        return queue;
    }

    private static int findMinIndex(Queue<Integer> queue, int index) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int element = queue.remove();
            if (element <= minValue && i <= index) {
                minIndex = i;
                minValue = element;
            }
            queue.add(element);
        }
        return minIndex;
    }

    private static void insert(Queue<Integer> queue, int minIndex) {
        int minValue = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int element = queue.remove();
            if (i == minIndex) {
                minValue = element;
            } else {
                queue.add(element);
            }
        }
        queue.add(minValue);
    }


}
