package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/partition-equal-subset-sum/description/

public class EqualSumSubset416 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(canDivide(arr));
    }

    private static boolean canDivide(int[] arr) {
        var sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0){
            return false;
        }
        int[][] dp = new int[arr.length + 1][sum/2 + 1];
        for(int[] dpArr : dp){
            Arrays.fill(dpArr, -1);
        }
        return canDivide(arr, 0, sum / 2, dp);
    }

    private static boolean canDivide(int[] arr, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || i >= arr.length) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        if (arr[i] > sum) {
            return canDivide(arr, i + 1, sum, dp);
        }
        var result = canDivide(arr, i + 1, sum - arr[i], dp)
                || canDivide(arr, i + 1, sum, dp);
        dp[i][sum] = result ? 1 : 0;
        return result;
    }
}
