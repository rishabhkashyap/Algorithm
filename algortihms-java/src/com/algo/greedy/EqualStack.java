package com.algo.greedy;

import java.util.Arrays;

public class EqualStack {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 8};
        int[] arr2 = {2, 2, 4, 9, 6};
        int[] arr3 = {2, 1, 2, 3};
//        int arr1[] = { 3, 2, 1, 1, 1 };
//        int arr2[] = { 4, 3, 2 };
//        int arr3[] = { 1, 1, 4, 1 };
//        int arr1[] = {3, 10};
//        int arr2[] = {4, 5};
//        int arr3[] = {2, 1};
        System.out.println(maxEqualSum(arr1, arr2, arr3));
    }

    private static int maxEqualSum(int[] arr1, int[] arr2, int[] arr3) {
        int sum1 = sum(arr1);
        int sum2 = sum(arr2);
        int sum3 = sum(arr3);
        int top1 = arr1.length - 1;
        int top2 = arr2.length - 1;
        int top3 = arr3.length - 1;
        while (top1 >= 0 && top2 >= 0 && top3 >= 0) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            if (sum1 > sum2 && sum1 > sum3) {
                sum1 -= arr1[top1--];
            } else if (sum2 > sum1 && sum2 > sum3) {
                sum2 -= arr2[top2--];
            } else if (sum3 > sum1 && sum3 > sum2) {
                sum3 -= arr3[top3--];
            }
        }
        return 0;
    }

    private static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
