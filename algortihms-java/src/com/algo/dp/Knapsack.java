package com.algo.dp;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int weight = 10;
        System.out.println(maxValue1(val, wt, weight));
        System.out.println(maxValue2(val, wt, weight));
    }

    private static int maxValue1(int[] val, int[] wt, int weight) {
        int[][] dp = new int[val.length + 1][weight + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxValue1(val, wt, weight, wt.length - 1, dp);
    }

    private static int maxValue1(int[] val, int[] wt, int weight, int i, int[][] dp) {
        if (weight <= 0 || i < 0) {
            return 0;
        }
        if (dp[i][weight] != -1) {
            return dp[i][weight];
        }
        if (weight < wt[i]) {
            return maxValue1(val, wt, weight, i - 1, dp);
        }
        dp[i][weight] = Math.max(
                maxValue1(val, wt, weight - wt[i], i - 1, dp) + val[i],
                maxValue1(val, wt, weight, i - 1, dp)
        );
        return dp[i][weight];
    }

    private static int maxValue2(int[] val, int[] wt, int weight) {
        int[][] dp = new int[val.length + 1][weight + 1];
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= weight; j++) {
                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[val.length][weight];

    }


}
