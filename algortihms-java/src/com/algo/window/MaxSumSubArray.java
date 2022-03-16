package com.algo.window;

import java.util.Arrays;

public class MaxSumSubArray {
    public static void main(String[] args) {
//        int[] arr = {100, 200, 300, 400};
//        int k = 2;
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Max sum of sub array = " + findMaxSum(arr, k));
    }

    private static int findMaxSum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while (j < arr.length) {
            curSum += arr[j];
            if (j - i + 1 > k) {
                curSum -= arr[i++];
            }
            if (j - i + 1 == k) {
                if (curSum > maxSum) {
                    maxSum = curSum;
                    start = i;
                    end = j;
                }
            }
            ++j;
        }
        System.out.print("Max sum sub array: ");
        Arrays.stream(arr, start, end + 1).forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n");
        return maxSum;
    }
}
