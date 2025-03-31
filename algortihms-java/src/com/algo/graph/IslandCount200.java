package com.algo.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Problem: https://leetcode.com/problems/number-of-islands/description/
public class IslandCount200 {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(countIslands(grid));
    }

    private static int countIslands(char[][] grid) {
        Set<Location> visited = new HashSet<>();
        var islands = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Location(i, j))) {
                    performDFS(grid, i, j, visited);
                    ++islands;
                }
            }
        }
        return islands;
    }

    private static void performDFS(char[][] grid, int i, int j, Set<Location> visited) {
        Queue<Location> queue = new LinkedList<>();
        var loc = new Location(i, j);
        queue.add(loc);
        visited.add(loc);
        int[][] neighbours = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        var rows = grid.length;
        var cols = grid[0].length;
        while (!queue.isEmpty()) {
            var temp = queue.remove();
            for (int[] neighbour : neighbours) {
                var nextRow = temp.i + neighbour[0];
                var nextCol = temp.j + neighbour[1];
                var nextLoc = new Location(nextRow, nextCol);
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                        && grid[nextRow][nextCol] == '1' && !visited.contains(nextLoc)) {
                    queue.add(nextLoc);
                    visited.add(nextLoc);
                }
            }
        }
    }

    private record Location(
            int i,
            int j
    ) {
    }
}
