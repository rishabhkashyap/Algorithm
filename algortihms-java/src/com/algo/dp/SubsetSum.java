package com.algo.dp;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
//        int[] arr = {3, 34, 4, 12, 5, 2};
//        int sum = 1000;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 16;
        System.out.println("Subset with sum = " + sum + " = " + subsetExists(arr, sum));
        System.out.println("Subset with sum = " + sum + " = " + subsetSumExists2(arr, sum));
    }

    private static boolean subsetExists(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        //Initialize dp for case where number of elements is greater than 0 and target sum is 0
        //which can be achieved by not considering any element
//        for (int i = 0; i <= arr.length; i++) {
//            dp[i][0] = true;
//        }
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && j > 0) {
                    dp[i][j] = false;
                } else {
                    if (j >= arr[i - 1]) {

                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }

    private static boolean subsetSumExists2(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return subsetSumExists2(arr, sum, arr.length - 1, dp);


    }

    private static boolean subsetSumExists2(int[] arr, int sum, int i, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1 ;
        }
        if (sum < arr[i]) {
            return subsetSumExists2(arr, sum, i - 1, dp);
        }
        boolean result = subsetSumExists2(arr, sum - arr[i], i - 1, dp)
                || subsetSumExists2(arr, sum, i - 1, dp);
        dp[i][sum] = result ? 1 : 2;
        return result;
    }
}
