package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class MinDelPalindrome1312 {
    public static void main(String[] args) {
        String str = "aebcbda";
        System.out.println("Minimum deletion to make string palindrome = " + countMinDeletions(str));
    }

    private static int countMinDeletions(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int palindromicSubsequenceLen = countMinDeletions(str, 0, str.length() - 1, dp);
        return str.length() - palindromicSubsequenceLen;
    }

    private static int countMinDeletions(String str, int i, int j, int[][] dp) {
        if (i >= str.length() || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str.charAt(i) == str.charAt(j)) {
            return countMinDeletions(str, i + 1, j - 1, dp) + 1;
        }
        int result1 = countMinDeletions(str, i + 1, j, dp);
        int result2 = countMinDeletions(str, i, j - 1, dp);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];
    }
}
