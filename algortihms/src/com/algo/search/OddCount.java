package com.algo.search;

public class OddCount {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        System.out.println("Element with odd count = " + findOddCountElement(arr));
    }

    private static int findOddCountElement(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
