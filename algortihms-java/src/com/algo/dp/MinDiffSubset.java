package com.algo.dp;

import java.util.Arrays;

public class MinDiffSubset {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr));
    }

    private static int minDifference(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int minDiff = Integer.MAX_VALUE;
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][0] = true;
                } else {
                    if (j < arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
        }
        for (int i = 1; i <= sum; i++) {
            if (dp[arr.length][i]) {
                minDiff = Math.min(minDiff, Math.abs(sum - 2 * i));
            }
        }
        return minDiff;
    }
}
