package com.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

public class PacificAtlantic417 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> result = findCoordinates(arr);
        result.forEach(e -> System.out.print(e + " "));
    }

    //DFS on top row, bottom row, first column, and last column to determine
    //all cells that can be reached from top row, bottom row, first column, and last column
    private static List<List<Integer>> findCoordinates(int[][] arr) {
        Set<Point> pacific = new HashSet<>();
        Set<Point> atlantic = new HashSet<>();
        for (int j = 0; j < arr[0].length; j++) {
            dfs(arr, 0, j, arr[0][j], pacific);
            dfs(arr, arr.length - 1, j, arr[arr.length - 1][j], atlantic);
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(arr, i, 0, arr[i][0], pacific);
            dfs(arr, i, arr[0].length - 1, arr[i][arr[0].length - 1], atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                var point = new Point(i, j);
                if (pacific.contains(point) && atlantic.contains(point)) {
                    result.add(Arrays.asList(point.x, point.y));
                }

            }
        }
        return result;
    }

    private static void dfs(int[][] arr, int i, int j, int previousHeight, Set<Point> ocean) {
        if (i < 0 || i == arr.length || j < 0 || j == arr[0].length) {
            return;
        }
        if (ocean.contains(new Point(i, j))) {
            return;
        }
        if (arr[i][j] < previousHeight) {
            return;
        }
        ocean.add(new Point(i, j));
        dfs(arr, i + 1, j, arr[i][j], ocean);
        dfs(arr, i - 1, j, arr[i][j], ocean);
        dfs(arr, i, j + 1, arr[i][j], ocean);
        dfs(arr, i, j - 1, arr[i][j], ocean);
    }

    private record Point(int x, int y) {
    }


}
