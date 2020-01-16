package com.algo.arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomSubset {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 1, 2, 9};
        int k = 4;
        int[] result = generateRandomSubset(arr, k);
        //System.out.println("Random subet");
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] generateRandomSubset(int[] input, int k) {
        int[] arr = Arrays.copyOf(input, input.length);
        for (int i = 0; i < k; i++) {
            swap(arr, getRandomIndexInRange(i, arr.length - 1), i);
        }
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static int getRandomIndexInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
