package com.algo.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RodCut {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int length = price.length;
        System.out.println(findMaxProfit1(price, length));
        System.out.println(findMaxProfit2(price, length));
    }

    private static int findMaxProfit1(int[] price, int length) {

        int[] lengths = IntStream.rangeClosed(1, price.length).toArray();
        int[][] dp = new int[price.length + 1][price.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findMaxProfit1(price, length, lengths, price.length - 1, dp);
    }

    private static int findMaxProfit1(int[] price, int length, int[] lengths, int i, int[][] dp) {
        if (i < 0 || length <= 0) {
            return 0;
        }
        if (dp[i][length] != -1) {
            return dp[i][length];
        }
        if (length < lengths[i]) {
            return findMaxProfit1(price, length, lengths, i - 1, dp);
        }
        int result1 = findMaxProfit1(price, length - lengths[i], lengths, i, dp) + price[i];
        int result2 = findMaxProfit1(price, length, lengths, i - 1, dp);
        dp[i][length] = Math.max(result1, result2);
        return dp[i][length];
    }

    private static int findMaxProfit2(int[] price, int length) {
        int[] lengths = IntStream.rangeClosed(1, price.length).toArray();
        int[][] dp = new int[lengths.length+1][length + 1];
        for (int i = 1; i <= lengths.length; i++) {
            for (int j = 1; j <= length; j++) {
                if (j < lengths[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - lengths[i - 1]] + price[i - 1]);
                }
            }
        }
        return dp[lengths.length][length];
    }

}
