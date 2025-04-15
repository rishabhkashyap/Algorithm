package com.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Problem: https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule207 {
    public static void main(String[] args) {
        int courses = 2;
        int[][] preReq = {{1, 0}, {0, 1}};
        System.out.println(finishCourse1(courses, preReq));
        System.out.println(finishCourse2(courses, preReq));
    }

    private static boolean finishCourse1(int courses, int[][] preReq) {
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
        return result.size() == courses;
    }

    private static boolean finishCourse2(int courses, int[][] preReq) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : preReq) {
            List<Integer> list = map.getOrDefault(arr[0], new ArrayList<>());
            list.add(arr[1]);
            map.put(arr[0], list);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < courses; i++) {
            if (!performDFS(i, map, visited)) {
                return false;
            }
        }
        return true;
    }

    //Problem boils down to detect cycle in a directed graph. If there is a cycle in graph
    // that means all courses cannot be covered
    private static boolean performDFS(int course, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        //Traversing dependent course if any course is visited twice that means there is
        //a cycle in graph and all coursed cannot be taken
        if (visited.contains(course)) {
            return false;
        }
        if (!map.containsKey(course)) {
            return true;
        }
        visited.add(course);
        for (int dependency : map.get(course)) {
            if (!performDFS(dependency, map, visited)) {
                return false;
            }
        }
        visited.remove(course);
        //if all dependent courses are covered remove it from adjacency list to
        //indicate that there is no dependency for current course
        map.remove(course);
        return true;
    }

}
