package com.algo.dp;

import java.io.IOException;
import java.util.Arrays;

public class LongestCommonSubSequence {

    public static void main(String[] args) throws IOException {

        String text1 = "abcde";
        String text2 = "ace";
//        String text1="AGGTAB";
//        String text2="GXTXAYB";
        System.out.println(getLongestSubsequenceLength1(text1, text2));
        System.out.println(getLongestSubsequenceLength2(text1, text2));
        System.out.println(getLongestSubsequenceLength3(text1, text2));
        System.out.println(getLongestSubsequenceLength4(text1, text2));
        System.out.println("Longest common subsequence = " + printLCS(text1, text2));

    }


    private static int getLongestSubsequenceLength1(String text1, String text2) {
        return longestSubsequenceHelper1(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    private static int longestSubsequenceHelper1(String text1, int index1, String text2, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return longestSubsequenceHelper1(text1, index1 - 1, text2, index2 - 1) + 1;
        }
        int result1 = longestSubsequenceHelper1(text1, index1, text2, index2 - 1);
        int result2 = longestSubsequenceHelper1(text1, index1 - 1, text2, index2);

        return Math.max(result1, result2);


    }

    private static int getLongestSubsequenceLength2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return longestSubsequenceHelper2(text1, text1.length() - 1, text2, text2.length() - 1, dp);
    }

    private static int longestSubsequenceHelper2(String text1, int index1, String text2, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return longestSubsequenceHelper2(text1, index1 - 1, text2, index2 - 1, dp) + 1;
        }
        int result1 = longestSubsequenceHelper2(text1, index1, text2, index2 - 1, dp);
        int result2 = longestSubsequenceHelper2(text1, index1 - 1, text2, index2, dp);
        dp[index1][index2] = Math.max(result1, result2);
        return dp[index1][index2];
    }


    //Fill array
    private static int getLongestSubsequenceLength3(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; --i) {
            for (int j = text2.length() - 1; j >= 0; --j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = ++dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    private static int getLongestSubsequenceLength4(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = ++dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[str1.length()][str2.length()];
    }

    private static String printLCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = ++dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0, str1.charAt(i - 1));
                --i;
                --j;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    --i;
                } else {
                    --j;
                }
            }
        }
        return sb.toString();
    }


}