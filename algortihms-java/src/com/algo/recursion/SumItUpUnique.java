package com.algo.recursion;
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
//where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.
//Problem: https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SumItUpUnique {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(getCombinations(arr, target));
    }

    private static List<List<Integer>> getCombinations(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, 0, target, list, result);
        return result;
    }

    private static void helper(int[] arr, int i, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i >= arr.length) {
            return;
        }
        list.add(arr[i]);
        helper(arr, i + 1, target - arr[i], list, result);
        list.remove(list.size() - 1);
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            ++i;
        }
        helper(arr, i + 1, target, list, result);
    }

}
