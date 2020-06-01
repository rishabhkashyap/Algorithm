package com.algo.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        //int[] arr = {4, 5, 6, 3, 2, 1};
        int[] arr = {6,2,1,5,4,3,0};
        int[] result = findNextPermutation(arr);
        System.out.println("Number");
        Arrays.stream(arr).forEach(e -> System.out.print(e));
        System.out.println("\nNext permutation");
        Arrays.stream(result).forEach(e -> System.out.print(e));
    }

    private static int[] findNextPermutation(int[] arr) {
        int[] number = Arrays.copyOf(arr, arr.length);
        int minIndex = -1;
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] > number[i - 1]) {
                minIndex = i - 1;
                break;
            }
        }
        int maxIndex = -1;
        if (minIndex != -1) {
            for (int i = number.length - 1; i >= 0; i--) {
                if (number[i] > number[minIndex]) {
                    maxIndex = i;
                    break;
                }
            }
            swap(number, minIndex, maxIndex);
            Arrays.sort(number, minIndex + 1, number.length);
        }

        return number;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
