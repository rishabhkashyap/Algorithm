package com.algo.dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String string1 = "GeeksforGeeks";
        String string2 = "GeeksQuiz";
//        String string1 = "zxabcdezy";
//        String string2 = "yzabcdezx";
        System.out.println("Longest common substring length = " + findLongestCommonSubstrLen(string1, string2));
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
