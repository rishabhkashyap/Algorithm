package com.algo.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumZero {

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        //int[] arr = {1, 0, 3};
        //int[] arr={1,9,3,4,5};
        System.out.println("Longest sub array with sum zero = " + findMaxLenSubArrayWithSumZero(arr));
    }

    private static int findMaxLenSubArrayWithSumZero(int[] arr) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
