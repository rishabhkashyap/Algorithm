package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/climbing-stairs/description/

public class ClimbingStairs70 {
    public static void main(String[] args) {
        var n = 3;
        System.out.println(countClimbStairWays(n));
    }

    private static int countClimbStairWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countClimbStairWays(n, dp);
    }

    private static int countClimbStairWays(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = countClimbStairWays(n - 1, dp) + countClimbStairWays(n - 2, dp);
        return dp[n];
    }
}
