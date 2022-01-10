package com.algo.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

//Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class KSmallestPairs {
	public static void main(String[] args) {
		int[] arr1 = { 1, 1, 2 };
		int[] arr2 = { 1, 2, 3 };
//		int[] arr1 = { 1, 7, 11 };
//		int[] arr2 = { 2, 4, 6 };
		int k = 3;
		List<List<Integer>> result = findKSmallestSumPairs(arr1, arr2, k);
		result.forEach(e -> {
			System.out.println();
			e.forEach(e1 -> System.out.print(e1 + "  "));
		});

	}

	private static List<List<Integer>> findKSmallestSumPairs(int[] arr1, int[] arr2, int k) {
		Queue<Pair> queue = new PriorityQueue<>((e1, e2) -> e1.getSum() - e2.getSum());
		for (int i = 0; i < arr1.length; i++) {
			queue.add(new Pair(i, 0, arr1[i] + arr2[0]));
		}
		List<List<Integer>> result = new ArrayList<>();
		int i = 0;
		while (i < k && !queue.isEmpty()) {
			Pair pair = queue.remove();
			result.add(Arrays.asList(arr1[pair.getIndex1()], arr2[pair.getIndex2()]));
			++i;
			if (pair.getIndex2() + 1 < arr2.length) {
				queue.add(new Pair(pair.getIndex1(), pair.getIndex2() + 1,
						arr1[pair.getIndex1()] + arr2[pair.getIndex2() + 1]));
			}

		}


		return result;
	}

	private static class Pair {
		private int index1;

		private int index2;

		private int sum;

		public Pair(int index1, int index2, int sum) {
			this.index1 = index1;
			this.index2 = index2;
			this.sum = sum;
		}

		public int getIndex1() {
			return index1;
		}

		public int getIndex2() {
			return index2;
		}

		public int getSum() {
			return sum;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair pair = (Pair) o;
			return index1 == pair.index1 && index2 == pair.index2 && sum == pair.sum;
		}

		@Override
		public int hashCode() {
			return Objects.hash(index1, index2, sum);
		}
	}
}
