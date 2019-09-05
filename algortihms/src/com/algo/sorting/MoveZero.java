package com.algo.sorting;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int arr[] = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        //int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Array before ordering");
        Arrays.stream(arr)
                .forEach(e -> System.out.print(e + "\t"));
        reorder(arr);
        System.out.println("\nArray after ordering");
        Arrays.stream(arr)
                .forEach(e -> System.out.print(e + "\t"));

    }

    private static void reorder(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                exchange(arr, i, index);
                ++index;
            }
        }
    }

    private static void exchange(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
