package com.algo.dp;

import java.util.Arrays;

public class TravellingSalesman {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}};
        System.out.println("Shortest path = " + findShortestPath(arr));
    }

    private static int findShortestPath(int[][] arr) {
        final int ALL_VISITED = (1 << arr.length) - 1;
        int[][] dp = new int[ALL_VISITED][arr.length];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        return findShortestPath(arr, 0, 1, dp, ALL_VISITED);


    }

    private static int findShortestPath(int[][] arr, int source, int cities, int[][] dp, int allVisited) {
        if (cities == allVisited) {
            return arr[source][0];
        }
        if (dp[cities][source] != -1) {
            return dp[cities][source];
        }
        dp[cities][source] = Integer.MAX_VALUE;
        for (int destination = 0; destination < arr.length; ++destination) {
            if (!isCityVisited(cities, destination)) {
                int distance = arr[source][destination] + findShortestPath(arr, destination, cities | (1 << destination), dp, allVisited);
                dp[cities][source] = Math.min(dp[cities][source], distance);
            }

        }
        return dp[cities][source];
    }

    private static boolean isCityVisited(int cities, int destination) {
        int temp = 1 << destination;
        return (temp & cities) != 0;
    }
}
