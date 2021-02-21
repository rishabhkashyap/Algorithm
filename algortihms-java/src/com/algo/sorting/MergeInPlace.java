package com.algo.sorting;

import java.util.Arrays;

public class MergeInPlace {
    public static void main(String[] args) {
//        int[] arr1 = {1, 4, 7, 8, 10};
//        int[] arr2 = {2, 3, 9};
        int arr1[] = {1, 5, 9, 10, 15, 20};
        int arr2[] = {2, 3, 8, 13};
        System.out.println("Array before merge");
        Arrays.stream(arr1).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(arr2).forEach(e -> System.out.print(e + "\t"));
        merge(arr1, arr2);
        System.out.println("\nArray after merge");
        Arrays.stream(arr1).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(arr2).forEach(e -> System.out.print(e + "\t"));
    }

    private static void merge(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[0]) {
                swapFirstElement(arr1, arr2, i);
                int k = 1;
                int temp = arr2[0];
                while (k < arr2.length && arr2[0] > arr2[k]) {
                    arr2[k - 1] = arr2[k];
                    k++;
                }
                arr2[k - 1] = temp;
            }
        }
    }

    private static void swapFirstElement(int[] arr1, int[] arr2, int index) {
        int temp = arr1[index];
        arr1[index] = arr2[0];
        arr2[0] = temp;
    }
}
