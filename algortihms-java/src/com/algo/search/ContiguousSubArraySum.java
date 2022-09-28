package com.algo.search;

public class ContiguousSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSumSubArray(arr));
    }

    private static int maxSumSubArray(int[] arr) {
        int sumSoFar = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : arr) {
            sumSoFar += num;
            maxSum = Math.max(maxSum, sumSoFar);
            if (sumSoFar < 0) {
                sumSoFar = 0;
            }
        }
        return maxSum;
    }
}
