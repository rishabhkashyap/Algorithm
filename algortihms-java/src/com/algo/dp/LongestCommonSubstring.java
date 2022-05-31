package com.algo.dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String string1 = "GeeksforGeeks";
        String string2 = "GeeksQuiz";
//        String string1 = "zxabcdezy";
//        String string2 = "yzabcdezx";
        System.out.println("Longest common substring length = " + findLongestCommonSubstrLen(string1, string2));
        System.out.println("Longest common substring length = " + findLongestCommonSubstrLen2(string1, string2));
        System.out.println("Longest common substring = " + findLongestCommonSubstr(string1, string2));
    }

    private static int findLongestCommonSubstrLen(String string1, String string2) {
        int[][] dp = new int[string1.length() + 1][string2.length() + 1];
        int maxLen = 0;

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j < string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = ++dp[i - 1][j - 1];
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    private static int findLongestCommonSubstrLen2(String string1, String string2) {
        int[][][] dp = new int[string1.length() + 1][string2.length() + 1][Math.min(string1.length(), string2.length())];
        for (int i = 0; i < string1.length(); i++) {
            for (int j = 0; j < string2.length(); j++) {
                for (int k = 0; k < Math.min(string1.length(), string2.length()); k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return findLongestCommonSubstrLen2(string1, string2, string1.length() - 1, string2.length() - 1, 0, dp);
    }

    private static int findLongestCommonSubstrLen2(String string1, String string2, int i, int j, int count, int[][][] dp) {
        if (i < 0 || j < 0) {
            return count;
        }
        if (dp[i][j][count] != -1) {
            return dp[i][j][count];
        }
        int len1 = count;
        if (string1.charAt(i) == string2.charAt(j)) {
            len1 = findLongestCommonSubstrLen2(string1, string2, i - 1, j - 1, count + 1, dp);
        }
        int len2 = findLongestCommonSubstrLen2(string1, string2, i - 1, j, 0, dp);
        int len3 = findLongestCommonSubstrLen2(string1, string2, i, j - 1, 0, dp);
        dp[i][j][count] = Math.max(len1, Math.max(len2, len3));
        return dp[i][j][count];
    }

    private static String findLongestCommonSubstr(String string1, String string2) {
        int[][] dp = new int[string1.length() + 1][string2.length() + 1];
        int row = 0;
        int col = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j < string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = ++dp[i - 1][j - 1];
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        row = i;
                        col = j;
                    }

                }
            }
        }
        //dp[i][j] reprensents longest common substring present in string1 ending at i
        // and string2 ending at j,row/col value associated with maxLen value will given end point of commons substring
        //start point of substring will be len-row or len-col
        return string1.substring(Math.abs(maxLen - row), row);
    }
}
