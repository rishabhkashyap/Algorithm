package com.algo.strings;

import java.util.StringTokenizer;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "abc";
        permuteString(str.toCharArray(), 0);
    }

    private static void permuteString(char[] arr, int i) {
        if (i == arr.length-1) {
            System.out.println(String.valueOf(arr));
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            permuteString(arr, i + 1);
            swap(arr, i, j);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
