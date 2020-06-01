package com.algo.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int k = 10;
        System.out.println("Finding pairs using hashset");
        findPairUsingHashset(arr, k);
        System.out.println("\nFinding pairs using sorting");
        findPairUsingSortig(arr, k);

    }

    private static void findPairUsingHashset(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int number : arr) {
            int difference = k - number;
            if (set.contains(difference)) {
                System.out.println("Number = " + number);
                System.out.println("Number = " + difference);
            }
            set.add(number);
        }
    }

    private static void findPairUsingSortig(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == k) {
                System.out.println("Number = " + arr[low]);
                System.out.println("Number = " + arr[high]);
                ++low;
                --high;
            } else if (sum > k) {
                --high;
            } else {
                ++low;
            }
        }
    }
}
