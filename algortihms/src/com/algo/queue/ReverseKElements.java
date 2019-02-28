package com.algo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String[] args){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.print("Orignal queue \n");
        queue.forEach(ele->System.out.print(ele +"\t"));
        Queue<Integer> reversedQueue=reverseKelements(queue,3);
        System.out.println("\n\nReversed queue with k element");
        reversedQueue.forEach(ele->System.out.print(ele+"\t"));

    }

    private static Queue<Integer> reverseKelements(Queue<Integer> queue, int k) {

        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<k;i++){
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        for(int i=0;i<queue.size()-k;i++){
            queue.add(queue.remove());
        }
        return queue;
    }

}
