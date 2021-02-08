package com.algo.dp;

import java.util.Arrays;

public class CoinGame {
    public static void main(String[] args) {

        //int[] arr = {5, 3, 7, 10};
        int[] arr={8, 15, 3, 7};
        System.out.println(getMaxScore(arr));

    }

    private static int getMaxScore(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length+1];
        for(int[] dpA:dp){
            Arrays.fill(dpA,-1);
        }
        return getMaxScore(arr, 0, arr.length - 1, dp);
    }

    private static int getMaxScore(int[] arr, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (j - i == 1) {
            return Math.max(arr[i], arr[j]);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result1 = arr[i] + Math.min(
                getMaxScore(arr, i + 2, j, dp),
                getMaxScore(arr, i + 1, j - 1, dp));
        int result2 = arr[j] + Math.min(
                getMaxScore(arr, i + 1, j - 1, dp),
                getMaxScore(arr, i, j - 2, dp));
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];
    }
}
