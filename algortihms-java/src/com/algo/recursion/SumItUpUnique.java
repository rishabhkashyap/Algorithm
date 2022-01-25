package com.algo.recursion;


//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
//where the candidate numbers sums to T. Each number in C may only be used ONCE in the combination.
//Problem: https://leetcode.com/problems/combination-sum-ii/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SumItUpUnique {
	public static void main(String[] args) throws IOException {


		int[] arr = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(combinationSum(arr, target));
	}

	public static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		Arrays.sort(arr);
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
			if (j > i && arr[j - 1] == arr[j]) {
				continue;
			}
			combination.add(arr[j]);
			combinationSum(arr, target, combination, result, j + 1, sum + arr[j]);
			combination.remove(combination.size() - 1);

		}
	}

}
