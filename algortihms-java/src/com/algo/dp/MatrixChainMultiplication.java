package com.algo.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
//        int[] arr = {10, 20, 30, 40, 30};
        int[] arr = {1, 2, 3, 4};
        System.out.println("Minimum operation required to do matrix multiplication = "
                + getMinOperations1(arr));
        System.out.println("Minimum operation required to do matrix multiplication = "
                + getMinOperations2(arr));


    }


    //Recursion
    private static int getMinOperations1(int[] arr) {
        return getMinOperations1(arr, 1, arr.length - 1);
    }

    private static int getMinOperations1(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = getMinOperations1(arr, i, k);
            cost += getMinOperations1(arr, k + 1, j);
            cost += arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }
        return min;
    }

    //Recursion+dp

    private static int getMinOperations2(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        return getMinOperations2(arr, 1, arr.length - 1, dp);
    }

    private static int getMinOperations2(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = getMinOperations2(arr, i, k, dp);
            cost += getMinOperations2(arr, k + 1, j, dp);
            cost += arr[i - 1] * arr[k] * arr[j];
            dp[i][j] = Math.min(dp[i][j], cost);
        }
        return dp[i][j];
    }

    private static int getMinOperations3(int[] arr) {
        return 0;

    }


}
