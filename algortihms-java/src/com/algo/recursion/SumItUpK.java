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
		result.forEach(e -> System.out.println(e));

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		combinationSum3(nums, 1, k, n, result);
		return result;

	}

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
}
