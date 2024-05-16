package com.algo.heaps;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/reorganize-string/description/
public class ReorganizeString767 {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(rearangeString(str));
    }

    private static String rearangeString(String str) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::count).reversed());
        Map<Character, Integer> map = str.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        map.forEach((key, value) -> priorityQueue.add(new Pair(key, value)));
        Pair prev = null;
        while (!priorityQueue.isEmpty()) {
            var curr = priorityQueue.remove();
            sb.append(curr.ch());
            curr = new Pair(curr.ch, curr.count - 1);
            if (prev != null && prev.count != 0) {
                priorityQueue.add(prev);
            }
            prev = curr;
        }
        return sb.length() < str.length() ? "" : sb.toString();
    }

    private record Pair(
            char ch,
            Integer count
    ) {
    }
}
