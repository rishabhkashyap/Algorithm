package com.algo.dp;

//Problem: https://leetcode.com/problems/palindromic-substrings/description/

public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        var string = "aaa";
        System.out.println(countSubstrings1(string));
        System.out.println(countSubstrings2(string));
    }

    private static int countSubstrings1(String string) {
        boolean[][] dp = new boolean[string.length()][string.length()];
        var count = 0;
        for (int i = 0; i < string.length(); i++) {
            dp[i][i] = true;
            ++count;
        }
        for (int len = 2; len <= string.length(); ++len) {
            for (int start = 0; start <= string.length() - len; ++start) {
                var end = start + len - 1;
                if ((string.charAt(start) == string.charAt(end))) {
                    if (dp[start + 1][end - 1]) {
                        ++count;
                        dp[start][end] = true;
                    }
                    if (end == (start + 1)) {
                        ++count;
                        dp[start][end] = true;
                    }
                }
            }
        }
        return count;
    }

    private static int countSubstrings2(String string) {
        var count = 0;
        //Expand outward for each character and check if palindromic substring is available
        //Consider substring of len 2
        for (int i = 0; i < string.length(); i++) {
            var left = i;
            var right = i;
            while (left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)) {
                ++count;
                --left;
                ++right;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)) {
                ++count;
                --left;
                ++right;
            }
        }
        return count;
    }
}
