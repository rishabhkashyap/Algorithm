package com.algo.sorting;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        System.out.println("Before sorting");
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
        removeDuplicates(arr);
        System.out.println("\nArray after sorting");
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
    }

    private static void removeDuplicates(int[] arr) {
        int j = 1;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[j-1] != arr[i]) {
                arr[j] = arr[i];
                ++j;
            }
        }
        while (j<arr.length){
            arr[j]=0;
            ++j;
        }
    }
}
