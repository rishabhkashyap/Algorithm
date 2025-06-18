package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Problem: https://leetcode.com/problems/minimum-height-trees/description/

public class MinHeightTree310 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        var result = findMinHeight(edges, n);
        System.out.println(result);
    }

    private static List<Integer> findMinHeight(int[][] edges, int n) {
        if (n == 1) {
            return List.of(0);
        }
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (var edge : edges) {
            inDegree.put(edge[0], inDegree.getOrDefault(edge[0], 0) + 1);
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
            var neighbours = adjMap.getOrDefault(edge[0], new ArrayList<>());
            neighbours.add(edge[1]);
            adjMap.put(edge[0], neighbours);
            neighbours = adjMap.getOrDefault(edge[1], new ArrayList<>());
            neighbours.add(edge[0]);
            adjMap.put(edge[1], neighbours);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (var i = 0; i < n; i++) {
            if (inDegree.containsKey(i) && inDegree.get(i) == 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            var size = queue.size();
            n -= size;
            while (size > 0) {
                var node = queue.remove();
                for (var neigh : adjMap.get(node)) {
                    var count = inDegree.get(neigh);
                    if (count != null && --count == 1) {
                        queue.add(neigh);
                        inDegree.remove(neigh);
                    } else {
                        inDegree.put(neigh, count);
                    }
                }
                --size;
            }
        }
        return new ArrayList<>(queue);
    }

}
