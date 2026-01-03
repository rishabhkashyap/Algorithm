package com.algo.dp;

import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/word-break/description/

public class WordBreak139 {
    public static void main(String[] args) {
        var string = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(breakWord(string, wordDict));
    }

    private static boolean breakWord(String string, List<String> wordDict) {
        int[][] dp = new int[string.length() + 1][string.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return breakWord(string, 0, string.length() - 1, wordDict, dp);
    }

    private static boolean breakWord(String string, int i, int j, List<String> wordDict, int[][] dp) {
        if (i > j) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (wordDict.contains(string.substring(i, j + 1))) {
            return true;
        }
        dp[i][j] = 0;
        for (int k = i; k < j; ++k) {
            if (breakWord(string, i, k, wordDict, dp) && breakWord(string, k + 1, j, wordDict, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }
        return false;
    }

}
