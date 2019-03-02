package com.algo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//Input :  1 2 3 4
//Output:  1 3 2 4
public class InterleavingQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        System.out.print("Orignal queue \n\n");
        queue.forEach(ele -> System.out.print(ele + "\t"));
        queue = interleaveQueue(queue);
        if (queue != null) {
            System.out.println("\n\nInterleaved queue with k element\n");
            queue.forEach(ele -> System.out.print(ele + "\t"));

        }

    }

    private static Queue<Integer> interleaveQueue(Queue<Integer> queue) {

        Stack<Integer> stack = new Stack<>();
        if (queue.size() % 2 != 0) {
            System.out.println("\n\nQueue cannot be interleaved ...since it does not have even number of elements");
            queue = null;
        } else {
            int halfSize = queue.size() / 2;
            //Push half of elements in stack
            for (int i = 0; i < halfSize; i++) {
                stack.push(queue.remove());
            }

            //Enqueue content of stack
            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }

            //dequeue half of the content of queue and enqueue it
            for (int i = 0; i < halfSize; i++) {
                queue.add(queue.remove());
            }

            //Put first half of queue back in stack
            for (int i = 0; i < halfSize; i++) {
                stack.push(queue.remove());
            }

            //Interleave queue
            while (!stack.isEmpty()) {
                queue.add(stack.pop());
                queue.add(queue.remove());
            }
        }
        return queue;

    }


}
