package com.algo.search;

import java.util.Arrays;

public class MissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        int[] arr1 = {1, 2, 2, 6, 3, 7, 8};
        int missingElement = getMissingElement(arr);
        System.out.println("Get missing element = " + missingElement);
        System.out.println("Get missing element = " + getMissingElement1(arr));
        missingElement = getMissingElelementDuplicate(arr1);
        System.out.println("Get missing element = " + missingElement);
    }

    private static int getMissingElement(int[] arr) {
        int x1 = 1;
        int x2 = arr[0];
        for (int i = 2; i <= arr.length + 1; i++) {
            x1 = x1 ^ i;
        }
        for (int i = 1; i < arr.length; i++) {
            x2 = x2 ^ arr[i];
        }
        return x1 ^ x2;
    }

    private static int getMissingElelementDuplicate(int[] arr) {
        int missingNumber = -1;
        boolean[] isAvailable = new boolean[20];
        for (int i = 0; i < arr.length; i++) {
            isAvailable[arr[i]] = true;
        }

        for (int i = 1; i < isAvailable.length; i++) {
            if (isAvailable[i] == false) {
                missingNumber = i;
                break;
            }
        }
        return missingNumber;
    }

    private static int getMissingElement1(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        int arrSum = Arrays.stream(arr).sum();
        return sum - arrSum;
    }


}
