package com.algo.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/top-k-frequent-elements/description/
public class KFrequentElement347 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = findTopK(arr, k);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] findTopK(int[] arr, int k) {
        Map<Integer, Integer> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        Queue<Pair> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(Pair::freq));
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Pair(key, map.get(key)));
            } else {
                if (priorityQueue.peek().freq() < map.get(key)) {
                    priorityQueue.remove();
                    priorityQueue.add(new Pair(key, map.get(key)));
                }
            }
        }
        return priorityQueue.stream().map(e -> e.num)
                .mapToInt(e -> e)
                .toArray();

    }

    private record Pair(int num, int freq) {
    }
}
