package com.algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        //int[] arr = {10, 5, 2, 7, 1, 9};
        //int[] arr = {1, -1, 5, -2, 3};
        int[] arr = {-5, 8, -14, 2, 4, 12};
        //int k = 15;
        //int k = 3;
        int k = -5;
        System.out.println("Longest sub array length = " + findLongestSubArray(arr, k));
    }

    private static int findLongestSubArray(int[] arr, int target) {
        int maxLen = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == target) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            if (map.containsKey(prefixSum - target)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - target));
            }
        }
        return maxLen;
    }
}
