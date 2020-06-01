package com.algo.recursion;

import java.util.ArrayList;
import java.util.List;


public class ArrayCombination {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        List<Integer> combination = new ArrayList<>();
        System.out.println("combinatination witout repition");
        createCombination(arr, k, combination, 0);
        System.out.println("\n\ncombinatination witout repition");
        createCombinationWithNoReps(arr, k, combination, 0);
    }

    private static void createCombinationWithNoReps(int[] arr, int k, List<Integer> combination, int index) {
        if (combination.size() == k) {
            print(combination);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            combination.add(arr[i]);
            createCombinationWithNoReps(arr, k, combination, i + 1);
            combination.remove(combination.size() - 1);
        }

    }

    private static void createCombination(int[] arr, int k, List<Integer> combination, int index) {
        if (combination.size() == k) {
            print(combination);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            combination.add(arr[i]);
            createCombination(arr, k, combination, i);
            combination.remove(combination.size() - 1);
        }
    }

    private static void print(List<Integer> combination) {
        combination.forEach(e -> System.out.print(e + "\t"));
        System.out.println();
    }
}
