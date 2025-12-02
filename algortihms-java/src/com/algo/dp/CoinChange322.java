package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change/description/

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        var target = 11;
        System.out.println(findMinChange(coins, target));
    }

    private static int findMinChange(int[] coins, int target) {
        int[][] dp = new int[coins.length + 1][target + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        var result = findMinChange(coins, target, 0, dp);
        return result == 99999 ? -1 : result;
    }

    private static int findMinChange(int[] coins, int target, int i, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (target < 0 || i >= coins.length) {
            return 99999;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if(target < coins[i]){
            return findMinChange(coins, target, i + 1, dp);
        }
        var opt1 = findMinChange(coins, target - coins[i], i, dp) + 1;
        var opt2 = findMinChange(coins, target, i + 1, dp);
        dp[i][target] = Math.min(opt1, opt2);
        return dp[i][target];
    }
}
