package com.algo.search;

public class DuplicateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4};
        System.out.println("Array has duplicate element = " + hasDuplicate(arr));
    }

    private static boolean hasDuplicate(int[] arr) {
        boolean duplicate = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] < 0) {
                duplicate = true;
                break;
            }
            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
        }
        return duplicate;
    }
}
