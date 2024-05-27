package com.algo.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
//Problem: https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPoints973 {
    public static void main(String[] args) {
        int[][] arr={{1,3},{-2,2}};
        int k=1;
        int[][] result=findKClosestPoints1(arr,k);
        for(int[] points:result){
            System.out.print(points[0]+"  "+points[1]);
        }
        System.out.println();
        result=findKClosestPoints2(arr,k);
        for(int[] points:result){
            System.out.print(points[0]+"  "+points[1]);
        }


    }


    private static int[][] findKClosestPoints1(int[][] arr, int k) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(k, Comparator.comparing(Point::distance).reversed());
        for (int[] point : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Point(point[0], point[1], calculateDistanceFromOrigin(point[0], point[1])));
            } else {
                Point pt = priorityQueue.peek();
                if (pt.distance() > calculateDistanceFromOrigin(point[0], point[1])) {
                    priorityQueue.remove();
                    priorityQueue.add(new Point(point[0], point[1], calculateDistanceFromOrigin(point[0], point[1])));
                }
            }
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Point point = priorityQueue.remove();
            result[i] = new int[]{point.x, point.y};
        }
        return result;
    }

    private static int[][] findKClosestPoints2(int[][] arr, int k) {
        List<Point> points = new ArrayList<>();
        Arrays.stream(arr).forEach(e -> points.add(new Point(e[0], e[1], calculateDistanceFromOrigin(e[0], e[1]))));
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(Point::distance));
        pq.addAll(points);
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Point point = pq.remove();
            result[i] = new int[]{point.x, point.y};
        }
        return result;
    }

    private record Point(int x, int y, double distance) {
    }

    private static double calculateDistanceFromOrigin(int x, int y) {
        return Math.sqrt((x * x) + (y * y));
    }
}
