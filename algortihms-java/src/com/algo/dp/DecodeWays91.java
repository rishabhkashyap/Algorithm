package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/decode-ways/description/

public class DecodeWays91 {

    public static void main(String[] args) {
        var string = "06";
        System.out.println(decodeWaysCount(string));
    }

    private static int decodeWaysCount(String string) {
        int[] dp = new int[string.length() + 1];
        Arrays.fill(dp, -1);
        return decodeWaysCount(string, 0, dp);
    }

    private static int decodeWaysCount(String string, int i, int[] dp) {
        if (i == string.length()) {
            return 1;
        }
        if (string.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = decodeWaysCount(string, i + 1, dp);
        if (i < string.length() - 1 && Integer.parseInt(string.substring(i, i + 2)) < 27) {
            dp[i] += decodeWaysCount(string, i + 2, dp);
        }
        return dp[i];
    }
}
