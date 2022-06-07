package com.algo.dp;

import java.util.Arrays;

public class StringConversion {
    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";
        System.out.println("Minimum number of insertion and deletion to convert string = " + minOperations1(str1, str2));
        System.out.println("Minimum number of insertion and deletion to convert string = " + minOperations2(str1, str2));
    }

    private static int minOperations1(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int lcsLen = minOperations1(str1, str2, str1.length() - 1, str2.length() - 1, dp);
        int deletion = str1.length() - lcsLen;
        int insertion = str2.length() - lcsLen;
        return deletion + insertion;
    }

    private static int minOperations1(String str1, String str2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return minOperations1(str1, str2, i - 1, j - 1, dp) + 1;
        }
        int result1 = minOperations1(str1, str2, i - 1, j, dp);
        int result2 = minOperations1(str1, str2, i, j - 1, dp);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];
    }

    private static int minOperations2(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int deletion = str1.length() - dp[str1.length()][str2.length()];
        int insertion = str2.length() - dp[str1.length()][str2.length()];
        return deletion + insertion;
    }
}
