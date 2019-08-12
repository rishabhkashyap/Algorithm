package com.algo.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 10, 6, 9};
        sortRecurseive(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "  ");
        }

    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    private static void sortRecurseive(int[] a, int n) {

        for (int j = 0; j < n - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
            if (n - 1 > 1) {
                sortRecurseive(a, n - 1);
            }
        }

    }

}
