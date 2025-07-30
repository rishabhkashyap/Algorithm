package com.algo.recursion;
//Find all possible combinations of k numbers that add up to a number n,
//given that only numbers from 1 to 9 can be used and each combination should
// be a unique set of numbers.
//Problem: https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class SumItUpK {

    public static void main(String[] args) {
        int target = 10;
        int k = 3;
        List<List<Integer>> result = combinationSum3(k, target);
        result.forEach(System.out::println);
        System.out.println();
        result = getCombinations(k, target);
        result.forEach(System.out::println);

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        combinationSum3(nums, 1, k, n, result);
        return result;

    }

    // We do not check whether the previous element is same as current element before
    // adding to list because all the number that are being used to generate combination
    // are unique
    private static void combinationSum3(List<Integer> nums, int i, int k, int n, List<List<Integer>> result) {
        if (nums.size() == k && n == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }
        if (i > 9 || n < 0 || nums.size() > k) {
            return;
        }
        for (int j = i; j <= 9; j++) {
            nums.add(j);
            combinationSum3(nums, j + 1, k, n - j, result);
            nums.remove(nums.size() - 1);
        }
    }

    //Every number has 2 choices:
    // 1.consider it as part of solution
    // 2. Do not consider it as part of solution
    private static List<List<Integer>> getCombinations(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(1, k, n, list, result);
        return result;
    }

    private static void helper(int i, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (k < 0 || n < 0 || i >= 10) {
            return;
        }
        list.add(i);
        helper(i + 1, k - 1, n - i, list, result);
        list.remove(list.size() - 1);
        helper(i + 1, k, n, list, result);
    }
}
