package com.algo.dp;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    private static String substring;


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
            dp[i][j] = 1;
            return 1;
        }
        //2 character string
        if (string.charAt(i) == string.charAt(j) && i + 1 == j) {
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
        int end = 0;
        int maxLen = 1;
        for (int i = 0; i < string.length(); i++) {
            dp[i][i] = true;
            start = i;
            end = i;
        }

        //Strings of length>=2
        for (int len = 2; len <= string.length(); ++len) {
            //i represnts start index of substring
            for (int i = 0; i <= string.length() - len; ++i) {
                //j represents end index of substring
                int j = i + len - 1;
                //Cheks of palindromic string greater than 2
                if (string.charAt(i) == string.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        end = j;
                        maxLen = len;
                    }

                }
                //Checks palindromic string of length 2
                if (string.charAt(i) == string.charAt(j) && i + 1 == j) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        end = j;
                        maxLen = len;
                    }
                }
            }

        }
        System.out.println("Longest substring = " + string.substring(start, end + 1));
        return maxLen;
    }

}
