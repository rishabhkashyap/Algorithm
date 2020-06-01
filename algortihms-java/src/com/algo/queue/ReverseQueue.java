package com.algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    public static void main(String[] args) {
        java.util.Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("Orignal queue \n");
        queue.forEach(ele -> System.out.print(ele + "\t"));
        reverse(queue);
        System.out.println("\n\n Reversed queue \n");
        queue.forEach(ele -> System.out.print(ele + "\t"));

    }

    private static void reverse(Queue<Integer> queue) {

        if (queue.isEmpty()) {
            return;
        } else {
            int temp = queue.remove();
            reverse(queue);
            queue.add(temp);
        }
    }
}
