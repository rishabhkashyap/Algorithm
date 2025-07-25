package com.algo.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
//where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
//Problem: https://leetcode.com/problems/combination-sum/
public class SumItUpRepeated {

    public static void main(String[] args) throws IOException {
        int[] input = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = getCombinations(input, target);
        result.forEach(System.out::println);
        System.out.println();
        result.clear();
        result = getCombinations2(input, target);
        result.forEach(System.out::println);
    }

    private static List<List<Integer>> getCombinations(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(arr, target, 0, list, result);
        return result;
    }

    private static void helper(int[] arr, int target, int i, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j < arr.length; j++) {
            list.add(arr[j]);
            helper(arr, target - arr[j], j, list, result);
            list.remove(list.size() - 1);
        }
    }

    //No loop
    private static List<List<Integer>> getCombinations2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        createCombinations(arr, target, 0, list, result);
        return result;
    }

    private static void createCombinations(int[] arr, int target, int i, List<Integer> list, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i >= arr.length){
            return;
        }
        list.add(arr[i]);
        createCombinations(arr, target - arr[i], i, list, result);
        list.remove(list.size() - 1);
        createCombinations(arr, target, i + 1, list, result);
    }
}
