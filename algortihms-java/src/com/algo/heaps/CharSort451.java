package com.algo.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/sort-characters-by-frequency/description/
public class CharSort451 {
    public static void main(String[] args) {
        String str = "tree";
        System.out.println(sortString(str));
    }

    private static String sortString(String string) {
        Map<Character, Integer> map = string.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::count).reversed());
        map.forEach((key, value) -> queue.add(new Pair(key, value)));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            var pair = queue.remove();
            char[] arr = new char[pair.count];
            Arrays.fill(arr, pair.ch);
            sb.append(arr);
        }
        return sb.toString();

    }

    private record Pair(char ch, int count) {
    }
}
