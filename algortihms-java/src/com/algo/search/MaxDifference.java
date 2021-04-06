package com.algo.search;

import java.util.Arrays;

public class MaxDifference {

    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println("Max difference using brute force approach = " + maxDiffBruteForce1(arr));
        System.out.println("Max difference using brute force approach = " + maxDiffBruteForce2(arr));
        System.out.println("Max difference using sorting = " + maxDifferenceUsingSorting(arr));
    }


    //Retuns max difference where larger element appears after smaller element
    private static int maxDiffBruteForce1(int[] arr) {
        int num1 = 0;
        int num2 = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > maxDiff) {
                    maxDiff = arr[j] - arr[i];
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }

        }
        System.out.println("num1 = " + num1 + "  " + "num2 = " + num2);
        return maxDiff;
    }

    //calculate absolute max difference
    private static int maxDiffBruteForce2(int[] arr) {
        int num1 = 0;
        int num2 = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > maxDiff) {
                    maxDiff = arr[j] - arr[i];
                    num1 = arr[i];
                    num2 = arr[j];
                }
            }

        }
        System.out.println("\nnum1 = " + num1 + "  " + "num2 = " + num2);
        return maxDiff;
    }

    private static int maxDifferenceUsingSorting(int[] arr) {
        Arrays.sort(arr);
        System.out.println("\nnum1 = " + arr[0] + "  " + "num2 = " + arr[arr.length - 1]);
        return arr[arr.length - 1] - arr[0];

    }

}
