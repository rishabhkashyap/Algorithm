package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/house-robber/description/

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return maxProfit(arr, 0, dp);
    }

    private static int maxProfit(int[] arr, int i, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        var profit1 = arr[i] + maxProfit(arr, i + 2, dp);
        var profit2 = maxProfit(arr, i + 1, dp);
        dp[i] = Math.max(profit1, profit2);
        return dp[i];
    }
}
