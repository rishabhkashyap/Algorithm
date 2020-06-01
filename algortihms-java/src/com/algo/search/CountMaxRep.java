package com.algo.search;

import java.util.Arrays;

public class CountMaxRep {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 9, 1, 7, 4, 4, 8, 9, 3, 2, 1, 9, 9, 7, 9};
        System.out.println("Max repeated element = " + getMaxRepeatedElementSorting(arr1));
    }

    private static int getMaxRepeatedElementSorting(int[] arr1) {
        Arrays.sort(arr1);
        return 0;
    }
}
