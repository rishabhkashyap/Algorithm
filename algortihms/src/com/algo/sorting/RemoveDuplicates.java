package com.algo.sorting;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
       // int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Before removing duplicates");
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
        removeDuplicates(arr);
        System.out.println("\n\nAfter removing duplicates");
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
    }

    private static void removeDuplicates(int[] arr) {
        int j = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[j - 1] != arr[i]) {
                arr[j] = arr[i];
                ++j;
            }
        }
        if (j + 1 < arr.length) {
            while (j < arr.length) {
                arr[j] = 0;
                ++j;
            }
        }
    }
}
