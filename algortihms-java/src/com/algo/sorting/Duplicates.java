package com.algo.sorting;

import java.util.Arrays;

public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
//        int[] arr = {2, 2, 2, 2, 2};
        removeDuplicates(arr);
    }

    private static void removeDuplicates(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[index] = arr[i];
                ++index;
            }
        }
        arr[index] = arr[arr.length - 1];
        Arrays.fill(arr, index + 1, arr.length, 0);
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
    }
}
