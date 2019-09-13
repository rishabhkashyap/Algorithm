package com.algo.sorting;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 1, 1, 0, 2, 2, 0, 1, 2, 0, 2};
        print(arr);
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                exchange(arr, mid, low);
                ++low;
                ++mid;
            } else if (arr[mid] == 1) {
                ++mid;
            } else {
                exchange(arr, mid, high);
                --high;
            }
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        System.out.println();
        Arrays.stream(arr)
                .forEach(e -> System.out.print(e + "\t"));
        System.out.println();
    }

}
