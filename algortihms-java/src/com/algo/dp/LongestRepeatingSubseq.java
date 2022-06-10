package com.algo.dp;

import java.util.Arrays;

public class LongestRepeatingSubseq {
    public static void main(String[] args) {
        String str = "axxzxy";
        System.out.println(longestRepeatingSubseqLen(str));
        System.out.println(longestRepeatingSubseqLen2(str));
    }

    private static int longestRepeatingSubseqLen(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return longestRepeatingSubseqLen(str, str, str.length() - 1, str.length() - 1, dp);
    }

    private static int longestRepeatingSubseqLen(String str1, String str2, int i, int j,
            int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i != j && str1.charAt(i) == str2.charAt(j)) {
            return longestRepeatingSubseqLen(str1, str2, i - 1, j - 1, dp) + 1;
        }
        int result1 = longestRepeatingSubseqLen(str1, str2, i - 1, j, dp);
        int result2 = longestRepeatingSubseqLen(str1, str2, i, j - 1, dp);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];

    }

    private static int longestRepeatingSubseqLen2(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if ((i - 1 != j - 1) && (str.charAt(i - 1) == str.charAt(j - 1))) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}
