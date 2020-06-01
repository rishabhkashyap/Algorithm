package com.algo.search;

import java.util.Arrays;

public class PairSumCloseToZero {
    public static void main(String[] args) {
        int arr[] = {1, 4, -5, 3, -2, 10, -6, 20};
        findPairWithSumCloseToZero(arr);
    }

    private static void findPairWithSumCloseToZero(int[] arr) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (low < high) {

        }
    }
}
