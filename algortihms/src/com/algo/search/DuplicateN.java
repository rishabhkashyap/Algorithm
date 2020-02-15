package com.algo.search;

public class DuplicateN {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 2, 3};
        //int[] arr = {1, 2, 3, 4, 5, 0};
        System.out.println("Array has duplicates = " + hasDuplicate(arr));
    }

    private static boolean hasDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                return true;
            }
            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
        return false;
    }
}
