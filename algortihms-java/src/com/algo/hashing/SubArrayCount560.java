package com.algo.hashing;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/subarray-sum-equals-k/

public class SubArrayCount560 {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 1};
//        int k = 2;
        int[] arr = {100, 1, 2, 3, 4};
        int k = 3;
        System.out.println(countSubArray(arr, k));
        System.out.println(countSubArrayBruteForce(arr, k));
    }

    private static int countSubArray(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        for (int ele : arr) {
            sum += ele;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    private static int countSubArrayBruteForce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    ++count;
                }
            }
        }
        return count;
    }
}
