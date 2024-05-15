package com.algo.heaps;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Problem: https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(findMinTimeToCompletion(arr, n));
    }

    private static int findMinTimeToCompletion(char[] arr, int n) {
        int time = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(map.values());
        Deque<CharData> deque = new ArrayDeque<>();
        while (!priorityQueue.isEmpty() || !deque.isEmpty()) {
            ++time;
            if (!priorityQueue.isEmpty()) {
                int task = priorityQueue.remove();
                if (--task != 0) {
                    deque.addLast(new CharData(task, time + n));
                }
            }
            if (!deque.isEmpty() && deque.peekFirst().timeToRemove == time) {
                CharData charData = deque.removeFirst();
                priorityQueue.add(charData.count);
            }
        }
        return time;
    }

    private record CharData(
            Integer count,
            Integer timeToRemove
    ) {
    }
}
