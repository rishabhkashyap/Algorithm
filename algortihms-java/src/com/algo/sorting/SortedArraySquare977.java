package com.algo.sorting;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedArraySquare977 {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        Arrays.stream(getSquares(arr)).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] getSquares(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        int k = arr.length - 1;
        while (i <= j) {
            if (arr[i] * arr[i] > arr[j] * arr[j]) {
                result[k] = arr[i] * arr[i];
                ++i;
            } else {
                result[k] = arr[j] * arr[j];
                --j;
            }
            --k;
        }
        return result;
    }
}
