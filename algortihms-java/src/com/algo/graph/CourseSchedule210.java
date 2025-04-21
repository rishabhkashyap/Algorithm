package com.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//Problem:https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule210 {
    public static void main(String[] args) {
        int courses = 2;
        int[][] preReq = {{1, 0}};
        Arrays.stream(getCourseOrder1(courses, preReq)).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(getCourseOrder2(courses, preReq)).forEach(e -> System.out.print(e + " "));
    }

    //BFS topological sort
    private static int[] getCourseOrder1(int courses, int[][] preReq) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int[] arr : preReq) {
            inDegree.put(arr[0], inDegree.getOrDefault(arr[0], 0) + 1);
            var neighbours = adjMap.getOrDefault(arr[1], new HashSet<>());
            neighbours.add(arr[0]);
            adjMap.put(arr[1], neighbours);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < courses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            var temp = queue.remove();
            result.add(temp);
            var neighbours = adjMap.get(temp);
            if (neighbours != null && !neighbours.isEmpty()) {
                for (int neighbour : neighbours) {
                    var count = inDegree.get(neighbour);
                    if (--count == 0) {
                        queue.add(neighbour);
                        inDegree.remove(neighbour);
                    } else {
                        inDegree.put(neighbour, count);
                    }
                }
            }
        }
        return result.size() == courses ? result.stream().mapToInt(e -> e).toArray() : new int[0];
    }

    //DFS topological sort
    private static int[] getCourseOrder2(int courses, int[][] preReq) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] arr : preReq) {
            var neighbours = adjMap.getOrDefault(arr[1], new ArrayList<>());
            neighbours.add(arr[0]);
            adjMap.put(arr[1], neighbours);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < courses; i++) {
            if (!performDFS(i, adjMap, visited, cycle, result)) {
                return new int[0];
            }
        }
        int[] res = new int[courses];
        var i =0;
        while (!result.isEmpty()){
           res[i++] = result.pop();
        }
        return res;
    }

    private static boolean performDFS(int i, Map<Integer, List<Integer>> adjMap, Set<Integer> visited,
                                      Set<Integer> cycle, Stack<Integer> result) {
        //there is cycle in graph so there is no way to cover all courses
        if (cycle.contains(i)) {
            return false;
        }
        if (visited.contains(i)) {
            return true;
        }
        cycle.add(i);
        var neighbours = adjMap.get(i);
        if (neighbours != null && !neighbours.isEmpty()) {
            for (int neighbour : neighbours) {
                if (!performDFS(neighbour, adjMap, visited, cycle, result)) {
                    return false;
                }
            }
        }
        cycle.remove(i);
        visited.add(i);
        result.add(i);
        return true;
    }

}
