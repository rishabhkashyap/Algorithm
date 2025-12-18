package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/longest-increasing-subsequence/description/
public class IncreasingSubSeq300 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(findMaxLen(arr));
        System.out.println(findMaxLen2(arr));
    }

    private static int findMaxLen(int[] arr) {
        int[][] dp = new int[arr.length + 2][arr.length + 2];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findMaxLen(arr, 0, -1, dp);
    }

    private static int findMaxLen(int[] arr, int i, int prev, int[][] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        var result1 = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            result1 = findMaxLen(arr, i + 1, i, dp) + 1;
        }
        var result2 = findMaxLen(arr, i + 1, prev, dp);
        dp[i][prev + 1] = Math.max(result1, result2);
        return dp[i][prev + 1];
    }

    private static int findMaxLen2(int[] arr) {
        int[] dp = new int[arr.length];
        var lis = 1;
        dp[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; --i) {
            var lisSoFar = 1;
            for (int j = arr.length - 1 ; j > i; --j) {
                if (arr[i] < arr[j]) {
                    lisSoFar = Math.max(lisSoFar, dp[j] + 1);
                }
            }
            dp[i] = lisSoFar;
            lis = Math.max(lis, lisSoFar);
        }
        return lis;
    }

}
