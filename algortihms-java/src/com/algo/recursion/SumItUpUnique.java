package com.algo.recursion;


//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
//where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SumItUpUnique {
    public static void main(String[] args) throws IOException {

        int[] input={2, 3, 5, 6, 8};
        int target=10;
        Arrays.sort(input);
        printSumCombination(input, target);
    }

    private static void printSumCombination(int[] input, int target) {
        List<Integer> sumNumber = new ArrayList<>();
        printSumCombinationHelper(input, target, sumNumber, 0);
    }

    private static boolean printSumCombinationHelper(int[] input, int target, List<Integer> sumNumber, int start) {
        if (target == 0) {
            printList(sumNumber);
            return false;
        }
        int prev = -1;
        for (int j = start; j < input.length; j++) {

            if (target >= 0 && input[j] != prev) {
                sumNumber.add(input[j]);
                boolean sumFound = printSumCombinationHelper(input, target - input[j], sumNumber, j + 1);
                if (sumFound) {
                    return true;
                }
                sumNumber.remove(sumNumber.size() - 1);
                prev = input[j];

            }
        }
        return false;
    }


    private static void printList(List<Integer> sumNumber) {
        sumNumber.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }


}
