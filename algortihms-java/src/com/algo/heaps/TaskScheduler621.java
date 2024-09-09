package com.algo.heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Problem: https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(findMinTimeToCompletion(arr, n));
    }

    private static int findMinTimeToCompletion(char[] arr, int n) {
        Map<Character, Integer> map = new HashMap<>();
        var output = 0;
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Task> queue = new LinkedList<>();
        priorityQueue.addAll(map.values());
        while (!priorityQueue.isEmpty() || !queue.isEmpty()) {
            ++output;
            if (!priorityQueue.isEmpty()) {
                var freq = priorityQueue.remove();
                if (--freq != 0) {
                    queue.add(new Task(freq, output + n));
                }
            }
            if (!queue.isEmpty() && queue.peek().nextAvailableTime == output) {
                var task = queue.remove();
                priorityQueue.add(task.freq);
            }
        }
        return output;
    }

    private  record Task(Integer freq, Integer nextAvailableTime) {
    }
}
