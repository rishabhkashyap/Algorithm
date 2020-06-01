package com.algo.sorting;

import java.util.Arrays;

public class Segregate {

    public static void main(String[] args) {
        int[] arr = {9, -3, 5, -2, -8, -6, 1, 3};
        System.out.println("Array before seggregation");
        printArr(arr);
        System.out.println();
        separateNumbers(arr);
        System.out.println("\nArray after seggregation");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr)
                .forEach(e -> System.out.print(e + "\t"));
    }

    private static void separateNumbers(int[] arr) {
        int pIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                swap(arr, i, pIndex);
                ++pIndex;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
