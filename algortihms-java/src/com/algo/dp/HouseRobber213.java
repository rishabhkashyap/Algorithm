package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber213 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        var result = findMaxValue(arr);
        System.out.println(result);
    }

    private static int findMaxValue(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        var opt1 = findMaxValue(arr, 0, arr.length - 2, dp);
        Arrays.fill(dp, -1);
        var opt2 = findMaxValue(arr, 1, arr.length - 1, dp);
        return Math.max(opt1, opt2);
    }

    private static int findMaxValue(int[] arr, int start, int end, int[] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        var profit1 = findMaxValue(arr, start + 2, end, dp) + arr[start];
        var profit2 = findMaxValue(arr, start + 1, end, dp);
        dp[start] = Math.max(profit1, profit2);
        return dp[start];
    }
}
