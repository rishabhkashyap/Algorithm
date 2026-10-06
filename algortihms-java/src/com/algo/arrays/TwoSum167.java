package com.algo.arrays;

import java.util.Arrays;

public class TwoSum167 {
    static void main() {
        int[] arr = {1, 2, 3, 4};
        int target = 3;
        int[] result = twoSum(arr, target);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = -1;
        int right = -1;
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            if (numbers[low] + numbers[high] == target) {
                left = low + 1;
                right = high + 1;
                break;
            }
            if (numbers[low] + numbers[high] < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{left, right};
    }
}
