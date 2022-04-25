package com.algo.window;

public class SumKSubarray {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
//        int[] arr = {-5, 8, -14, 2, 4, 12};
//        int k = -5;
        System.out.println(largestSubarrayLen(arr, k));
    }


    //This approach works on positive numbers
    private static int largestSubarrayLen(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxLen = Integer.MIN_VALUE;
        while (j < arr.length) {
            currentSum += arr[j];
            while (currentSum > k) {
                currentSum -= arr[i++];
            }
            if (currentSum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            ++j;

        }
        return maxLen;
    }
}
