package com.algo.dp;

//Problem: https://leetcode.com/problems/shortest-common-supersequence/

public class SuperSequence {
    public static void main(String[] args) {
//        String str1 = "AGGTAB";
//        String str2 = "GXTXAYB";
        String str1="bbabacaa";
        String str2="cccababab";
        System.out.println("Length of shortest super sequence = " + shortestSuperSeqLen(str1, str2));
        System.out.println("shortest super sequence = " + shortestSuperSeq(str1, str2));
        System.out.println("shortest super sequence = " + shortestCommonSuperSequence(str1, str2));
    }

    private static int shortestSuperSeqLen(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return str1.length() + str2.length() - dp[str1.length()][str2.length()];
    }

    private static String shortestSuperSeq(String str1, String str2) {
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
                    sb.insert(0, str1.charAt(i - 1));
                    --i;
                } else {
                    sb.insert(0, str2.charAt(j - 1));
                    --j;
                }
            }
        }
        while (i > 0) {
            sb.insert(0, str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.insert(0, str2.charAt(j - 1));
            j--;
        }
        return sb.toString();

    }


    public static String shortestCommonSuperSequence(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int row = 1; row < str1.length() + 1; row++) {
            for (int col = 1; col < str2.length() + 1; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1))
                    dp[row][col] = 1 + dp[row - 1][col - 1];

                else
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
            }
        }

        int idx1 = str1.length(), idx2 = str2.length();
        StringBuilder ans = new StringBuilder();

        while (idx1 > 0 && idx2 > 0) {
            if (str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1)) {
                ans.insert(0, str1.charAt(idx1 - 1));
                idx1--;
                idx2--;
            } else {
                if (dp[idx1 - 1][idx2] > dp[idx1][idx2 - 1]) {
                    ans.insert(0, str1.charAt(idx1 - 1));
                    idx1--;
                } else {
                    ans.insert(0, str2.charAt(idx2 - 1));
                    idx2--;
                }
            }
        }

        while (idx1 > 0) {
            ans.insert(0, str1.charAt(idx1 - 1));
            idx1--;
        }

        while (idx2 > 0) {
            ans.insert(0, str2.charAt(idx2 - 1));
            idx2--;
        }
        return ans.toString();
    }

}
