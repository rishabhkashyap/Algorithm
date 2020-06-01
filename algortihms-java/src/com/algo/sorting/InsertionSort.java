package com.algo.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        //int[] arr = {5, 2, 1, 10, 6, 9};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + "  ");
        }

    }

    private static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                --j;
            }
            arr[j] = temp;
        }

    }
}
