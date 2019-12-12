package com.algo.recursion;

public class HeapsPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        heapsPermutation(arr);
    }

    private static void heapsPermutation(int[] arr) {
        heapsPermutationHelper(arr, arr.length);
    }

    private static void heapsPermutationHelper(int[] arr, int size) {
        if (size == 1) {
            printArr(arr);
            return;
        }
        for (int i = 0; i < size; i++) {
            heapsPermutationHelper(arr, size - 1);
            if (size % 2 == 1) {
                swap(arr, 0, size - 1);
            } else {
                swap(arr, i, size - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}

