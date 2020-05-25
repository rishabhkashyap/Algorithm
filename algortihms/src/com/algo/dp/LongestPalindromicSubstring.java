package com.algo.dp;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    private static String substring;
    private static int start = Integer.MAX_VALUE;
    private static int end = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        String string = "cbbd";
        String string = "geeksskeeg";
        System.out.println("Length of longest palindromic substring = "
                + findLongestSubstringLength1(string));
        System.out.println("Length of longest palindromic substring = "
                + findLongestSubstringLength2(string));

    }

    private static int findLongestSubstringLength1(String string) {
        int[][] dp = new int[string.length() + 1][string.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findLongestSubstringLength1(string, 0, string.length() - 1, dp);

    }

    private static int findLongestSubstringLength1(String string, int i, int j, int[][] dp) {

        if (i >= string.length() || j < 0) {
            return 0;
        }
        //Single character
        if (i == j) {
            substring = string.substring(i, i + 1);
            dp[i][j] = 1;
            return 1;
        }
        //2 character string
        if (string.charAt(i) == string.charAt(j) && i + 1 == j) {
            substring = string.substring(i + 1, j);
            dp[i][j] = 2;
            return 2;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (string.charAt(i) == string.charAt(j)) {
            return findLongestSubstringLength1(string, i + 1, j - 1, dp) + 2;
        }
        int result1 = findLongestSubstringLength1(string, i + 1, j, dp);
        int result2 = findLongestSubstringLength1(string, i, j - 1, dp);
        dp[i][j] = Math.max(result1, result2);
        return dp[i][j];
    }

    private static int findLongestSubstringLength2(String string) {
        boolean[][] dp = new boolean[string.length() + 1][string.length() + 1];
        //String of length 1
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < string.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
            }
        }

        //Strings grater than length 2
        for (int len = 3; len <= string.length(); ++len) {
            //i represnts start index of substring
            for (int i = 0; i <= string.length() - len; ++i) {
                //j represents end index of substring
                int j = i + len - 1;
                if (string.charAt(i) == string.charAt(j)
                        && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

}
