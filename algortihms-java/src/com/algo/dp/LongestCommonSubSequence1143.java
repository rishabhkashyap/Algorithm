package com.algo.dp;

import java.io.IOException;
import java.util.Arrays;

//Problem: https://leetcode.com/problems/longest-common-subsequence/description/

public class LongestCommonSubSequence1143 {

    public static void main(String[] args) throws IOException {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(getLongestSubsequenceLength(text1, text2));
    }

    private static int getLongestSubsequenceLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getLongestSubsequenceLength(s1, s2, 0, 0, dp);
    }

    private static int getLongestSubsequenceLength(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = getLongestSubsequenceLength(s1, s2, i + 1, j + 1, dp) + 1;
        } else {
            var opt1 = getLongestSubsequenceLength(s1, s2, i + 1, j, dp);
            var opt2 = getLongestSubsequenceLength(s1, s2, i, j + 1, dp);
            dp[i][j] = Math.max(opt1, opt2);
        }
        return dp[i][j];
    }


}