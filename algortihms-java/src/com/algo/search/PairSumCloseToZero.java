package com.algo.search;

import java.util.Arrays;

public class PairSumCloseToZero {
    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        findPairWithSumCloseToZeroUsingSorting(arr);
        findPairWithSumCloseToZeroBruteForce(arr);
    }

    private static void findPairWithSumCloseToZeroBruteForce(int[] arr) {
        int num1 = 0;
        int num2 = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; ++j) {
                int minSoFar = arr[i] + arr[j];
                if (Math.abs(min) > Math.abs(minSoFar)) {
                    min = minSoFar;
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }
        }
        System.out.println("Num1 = " + num1 + "  " + "Num2 = " + num2);

    }

    private static void findPairWithSumCloseToZeroUsingSorting(int[] arr) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int numLeft = 0;
        int numRight = 0;
        int min = Integer.MAX_VALUE;
        while (low < high) {
            int minSumSofar = arr[low] + arr[high];
            if (Math.abs(min) > Math.abs(minSumSofar)) {
                min = minSumSofar;
                numLeft = arr[low];
                numRight = arr[high];
            }
            if (minSumSofar > 0) {
                --high;
            } else {
                ++low;
            }

        }
        System.out.println("Num1 = " + numLeft + "  " + "Num2 = " + numRight);
    }
}
