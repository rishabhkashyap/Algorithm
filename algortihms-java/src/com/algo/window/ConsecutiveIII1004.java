package com.algo.window;

public class ConsecutiveIII1004 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(maxOneStringLen(arr, k));
    }

    private static int maxOneStringLen(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int count = 0;
        while (j < arr.length) {
            if (arr[j] == 1) {
                ++count;
            }
            if (j - i + 1 - count <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (j - i + 1 - count > k) {
                if (arr[i] == 1) {
                    --count;
                }
                ++i;
            }
            ++j;
        }
        return maxLen;
    }
}
