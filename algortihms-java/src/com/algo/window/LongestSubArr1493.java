package com.algo.window;

//Problem: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
public class LongestSubArr1493 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(maxLenSubArr(arr));
    }

    private static int maxLenSubArr(int[] arr) {
        int i = 0;
        int j = 0;
        int count = 0;
        int maxLen = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                ++count;
            }
            while (count > 1) {
                if (arr[i] == 0) {
                    --count;
                }
                ++i;
            }
            maxLen = Math.max(maxLen, j - i);
            ++j;
        }
        return maxLen;
    }
}
