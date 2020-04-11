package com.algo.dp;

public class MaxSumSubArray {
    public static void main(String[] args) {
        //int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        // int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        //int[] arr = {-2, -1,-3,4,-1,2,1,-5,4};
        int[] arr = {1, 2};
        System.out.println("Max sum subarray using brute force = " + getMaxSumBruteForce(arr));
        System.out.println("Max sum subarray  using recursion= " + getMaxSumRecursion(arr));
        System.out.println("Max sum subarray  using recursion with optimization= " + getMaxSumRecursionOptimize(arr));
    }

    private static int getMaxSumBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int maxSumSoFar = 0;
            for (int j = i; j < arr.length; j++) {
                maxSumSoFar += arr[j];
                if (maxSumSoFar > maxSum) {
                    maxSum = maxSumSoFar;
                }
            }
        }
        return maxSum;
    }

    private static int getMaxSumRecursion(int[] arr) {
        return maxSumRecursionHelper(arr, arr.length - 1);
    }

    private static int maxSumRecursionHelper(int[] arr, int n) {

        if (n == 0) {
            return arr[0];
        }

        int maxSum = maxSumRecursionHelper(arr, n - 1);
        int maxSumSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += arr[i];
            if (sum > maxSumSoFar) {
                maxSumSoFar = sum;
            }
        }
        return Math.max(maxSumSoFar, maxSum);
    }

    private static int getMaxSumRecursionOptimize(int[] arr) {
        return maxSumOptimizedHelper(arr, arr.length - 1, 0);
    }

    private static int maxSumOptimizedHelper(int[] arr, int n, int sum) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return sum + arr[0];
        }
        int maxSum = 0;
        if (sum + arr[n] > 0) {
            maxSum = maxSumOptimizedHelper(arr, n - 1, sum + arr[n]);
        } else {
            maxSum = maxSumOptimizedHelper(arr, n - 1, 0);
        }
        return Math.max(maxSum, sum + arr[n]);


    }
}
