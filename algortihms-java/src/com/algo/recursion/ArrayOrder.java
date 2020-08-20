package com.algo.recursion;

public class ArrayOrder {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {1, 2, 3, 10,4, 5, 6};
        System.out.println("Array is sorted = " + isSorted(arr));
    }

    private static boolean isSorted(int[] arr) {
        return isSorted(arr, 0);
    }

    private static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] < arr[i + 1]) {
            return isSorted(arr, i + 1);
        } else {
            return false;
        }
    }
}
