package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/unique-paths/description/

public class UniquePaths62 {

    public static void main(String[] args) {
        var m = 3;
        var n = 7;
        System.out.println(countPaths(m, n));
    }

    private static int countPaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return countPaths(m, n, 0, 0, dp);
    }

    private static int countPaths(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i > m || j > n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = countPaths(m, n, i + 1, j, dp)
                + countPaths(m, n, i, j + 1, dp);
        return dp[i][j];
    }
}
