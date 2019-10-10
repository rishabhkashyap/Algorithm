package com.algo.search;

import java.util.Arrays;

public class SumTriplet {

    public static void main(String[] args) {
        int[] numbers = {1, 4, 45, 6, 10, 8};
        int target = 22;
        // int[] numbers = {0, -1, 2, -3, 1};
        //int target = -2;
        printTriplet(numbers, target);
    }

    private static void printTriplet(int[] numbers, int target) {

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int currentSum = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                if (numbers[left] + numbers[right] == currentSum) {
                    System.out.println(numbers[i] + "\t" + numbers[left] + "\t" + numbers[right]);
                    return;
                }
                if (numbers[left] + numbers[right] < currentSum) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        System.out.println("No triplet found");

    }
}
