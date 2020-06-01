package com.algo.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //{5, 2, 1, 10, 6, 9};
        sortRecursive(arr, 0);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestIndex] > arr[j]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    private static void sortRecursive(int[] arr, int index) {
        int smallestIndex = index;
        for (int j = index + 1; j < arr.length; j++) {
            if (arr[smallestIndex] > arr[j]) {
                smallestIndex = j;
            }
        }
        int temp = arr[index];
        arr[index] = arr[smallestIndex];
        arr[smallestIndex] = temp;
        if (index < arr.length - 1) {
            sortRecursive(arr, index + 1);
        }
    }


}
