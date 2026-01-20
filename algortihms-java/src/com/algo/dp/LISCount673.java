package com.algo.dp;

//Problem: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

public class LISCount673 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(countLIS(arr));
    }

    private static int countLIS(int[] arr) {
        var count = 1;
        var lis = 1;
        int[] dp = new int[arr.length];
        int[] lisCount = new int[arr.length];
        dp[dp.length - 1] = 1;
        lisCount[lisCount.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; --i) {
            var curMaxLen = 1;
            var curMaxCount = 1;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] < arr[j]) {
                    if (curMaxLen < dp[j] + 1) {
                        curMaxLen = dp[j] + 1;
                        curMaxCount = lisCount[j];
                    } else if (curMaxLen == dp[j] + 1) {
                        curMaxCount += lisCount[j];
                    }
                }
            }
            dp[i] = curMaxLen;
            lisCount[i] = curMaxCount;
            if (lis < curMaxLen) {
                lis = curMaxLen;
                count = curMaxCount;
            } else if (lis == curMaxLen) {
                count += curMaxCount;
            }
        }
        return count;
    }
}
