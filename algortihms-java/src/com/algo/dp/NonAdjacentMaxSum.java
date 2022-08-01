package com.algo.dp;

import java.util.Arrays;

//Problem: https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1

public class NonAdjacentMaxSum {
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(maxSum1(arr));
        System.out.println(maxSum2(arr));
    }

    private static int maxSum1(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return maxSum1(arr, 0, dp);
    }

    private static int maxSum1(int[] arr, int i, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int op1 = maxSum1(arr, i + 1, dp);
        int op2 = maxSum1(arr, i + 2, dp) + arr[i];
        dp[i] = Math.max(op1, op2);
        return dp[i];
    }

    private static int maxSum2(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[1] = arr[0];
        for (int i = 2; i <= arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[arr.length];
    }
}
