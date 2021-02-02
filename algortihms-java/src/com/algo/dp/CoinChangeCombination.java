//https://www.geeksforgeeks.org/coin-change-dp-7/

package com.algo.dp;

import java.util.Arrays;

public class CoinChangeCombination {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        int target = 4;
        int[] arr = {1, 3, 5, 7};
        int target = 8;
        System.out.println(findAllCoinChangeCombination(target, arr));
    }

    private static int findAllCoinChangeCombination(int target, int[] arr) {
        int[][] dp = new int[100][100];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return findAllCoinChangeCombination(target, arr, dp, 0);
    }

    private static int findAllCoinChangeCombination(int target, int[] arr, int[][] dp, int i) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || i >= arr.length) {
            return 0;
        }
        if (dp[target][i] != -1) {
            return dp[target][i];
        }
        int result1 = findAllCoinChangeCombination(target - arr[i], arr, dp, i);
        int result2 = findAllCoinChangeCombination(target, arr, dp, i + 1);
        dp[target][i] = result1 + result2;
        return dp[target][i];
    }
}
