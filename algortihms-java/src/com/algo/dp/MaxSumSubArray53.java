package com.algo.dp;

//Problem: https://leetcode.com/problems/maximum-subarray/description/
public class MaxSumSubArray53 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSum(arr));
    }

    private static int findMaxSum(int[] arr) {
        var maxSum = Integer.MIN_VALUE;
        var maxSumSoFar = 0;
        for (int num : arr) {
            maxSumSoFar += num;
            maxSum = Math.max(maxSum, maxSumSoFar);
            if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            }
        }
        return maxSum;
    }
}
