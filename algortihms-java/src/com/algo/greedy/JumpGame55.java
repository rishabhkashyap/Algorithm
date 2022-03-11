package com.algo.greedy;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/jump-game/

public class JumpGame55 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        //int[] arr = {2, 3, 1, 1, 4};
        System.out.println(canReachEnd1(arr));
        System.out.println(canReachEnd2(arr));
    }

    //DP solution
    private static boolean canReachEnd1(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return canReachEnd1(arr, 0, dp);
    }

    private static boolean canReachEnd1(int[] arr, int i, int[] dp) {
        if (i >= arr.length - 1) {
            return true;
        }
        if (dp[i] != -1) {
            return dp[i] == 1;
        }
        for (int j = 1; j <= arr[i]; j++) {
            boolean result = canReachEnd1(arr, j + i, dp);
            if (result) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 2;
        return false;
    }

    //Greedy solution
    private static boolean canReachEnd2(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        int end = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; --i) {
            if (i + arr[i] >= end) {
                end = i;
            }
        }
        return end == 0;
    }

}
