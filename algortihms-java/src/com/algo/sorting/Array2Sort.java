package com.algo.sorting;

import java.util.Arrays;

public class Array2Sort {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};
        System.out.println("Array before sorting");
        displayArray(arr1);
        displayArray(arr2);
        System.out.println("Array after sorting");
        sortArrays(arr1, arr2);
        displayArray(arr1);
        displayArray(arr2);

    }

    private static void displayArray(int[] arr) {
        Arrays.stream(arr)
                .forEach(e -> System.out.print(e + "\t"));
        System.out.println();
    }

    private static void sortArrays(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            int temp = 0;
            if (arr1[i] > arr2[0]) {
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }
            int first = arr2[0];
            int j;
            for (j = 1; j < arr2.length && first > arr2[j]; j++) {
                arr2[j - 1] = arr2[j];
            }
            arr2[j - 1] = first;

        }

    }


}
