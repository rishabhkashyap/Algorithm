package com.algo.dp;

import java.util.Arrays;

public class LongestRepeatingSubseq {
    public static void main(String[] args) {
        String str = "aabebcdd";
        System.out.println("Length of longest repeating subsequence = "+longestRepeatingSubseqLen(str));
        System.out.println("Length of longest repeating subsequence = "+longestRepeatingSubseqLen2(str));
        System.out.println("Longest repeating subsequence = " + printLongestRepeatingSubseq(str));
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
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str.length()][str.length()];
    }

    private static String printLongestRepeatingSubseq(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if ((i - 1 != j - 1) && (str.charAt(i - 1) == str.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = str.length();
        int j = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if ((i - 1 != j - 1) && (str.charAt(i - 1) == str.charAt(j - 1))) {
                stringBuilder.insert(0, str.charAt(i - 1));
                --i;
                --j;
            }
            else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    --i;
                }
                else {
                    --j;
                }
            }
        }
        return stringBuilder.toString();
    }
}
