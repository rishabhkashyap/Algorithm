package com.algo.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
//where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
//Problem: https://leetcode.com/problems/combination-sum/
public class SumItUpRepeated {

    public static void main(String[] args) throws IOException {

        int[] input = {2, 3, 5, 6, 8};
        int target = 10;
        List<List<Integer>> result=combinationSum(input, target);
        result.forEach(e->System.out.println(e));
    }



	public static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		combinationSum(arr, target, combination, result, 0, 0);
		return result;
	}

	public static void combinationSum(int[] arr, int target, List<Integer> combination,
			List<List<Integer>> result, int i, int sum) {
		if (i > arr.length) {
			return;
		}
		if (sum == target) {
			result.add(new ArrayList<>(combination));
			return;
		}
		if (sum > target) {
			return;
		}

		for (int j = i; j < arr.length; j++) {

			combination.add(arr[j]);
			combinationSum(arr, target, combination, result, j, sum + arr[j]);
			combination.remove(combination.size() - 1);

		}
	}

}
