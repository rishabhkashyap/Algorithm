package com.algo.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DistinctPermutation {
	public static void main(String[] args) {
		String string = "baa";
		List<String> result = findAllPermutations(string);
		System.out.println(result);
		System.out.println("\nWithout loop to check repetition of characters");
		result = findAllPermutations2(string);
		System.out.println(result);
	}

	private static List<String> findAllPermutations(String string) {
		List<String> result = new ArrayList<>();
		findAllPermutations(string.toCharArray(), 0, result);
		return result;
	}

	private static void findAllPermutations(char[] arr, int i, List<String> result) {
		if (i == arr.length - 1) {
			result.add(String.valueOf(arr));
			return;
		}
		if (i >= arr.length) {
			return;
		}
		for (int j = i; j < arr.length; j++) {
			if (isSwapValid(arr, i, j)) {
				swap(arr, i, j);
				findAllPermutations(arr, i + 1, result);
				swap(arr, i, j);
			}
		}
	}

	private static boolean isSwapValid(char[] arr, int start, int end) {
		for (int i = start; i < end; i++) {
			if (arr[i] == arr[end]) {
				return false;
			}
		}
		return true;
	}

	private static List<String> findAllPermutations2(String string) {
		List<String> result = new ArrayList<>();
		char[] arr = new char[string.length()];
		Map<Character, Integer> map = createMap(string);
		List<Character> keys = new ArrayList<>(map.keySet());
		findAllPermutations2(arr, 0, result, map, keys);
		return result;
	}

	private static Map<Character, Integer> createMap(String string) {
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < string.length(); i++) {
			int count = map.getOrDefault(string.charAt(i), 0);
			map.put(string.charAt(i), ++count);
		}
		return map;
	}

	private static void findAllPermutations2(char[] arr, int i, List<String> result,
			Map<Character, Integer> map, List<Character> keys) {
		if (i == arr.length) {
			result.add(String.valueOf(arr));
			return;
		}
		if (i >= arr.length) {
			return;
		}
		for (int j = 0; j < keys.size(); j++) {
			int count = map.get(keys.get(j));
			if (count > 0) {
				--count;
				map.put(keys.get(j), count);
				arr[i] = keys.get(j);
				findAllPermutations2(arr, i + 1, result, map, keys);
				++count;
				map.put(keys.get(j), count);
			}

		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
