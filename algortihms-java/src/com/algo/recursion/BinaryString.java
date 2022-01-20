package com.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryString {
	public static void main(String[] args) {
		int k = 4;
		List<String> result = generate(k);
		result.forEach(e -> System.out.println(e));
	}

	private static List<String> generate(int k) {
		char[] arr = new char[k];
		List<String> result = new ArrayList<>();
		arr[0] = '0';
		generate(arr, result, 1, k - 1);
		arr = new char[k];
		arr[0] = '1';
		generate(arr, result, 1, k - 1);
		return result;
	}

	private static void generate(char[] arr, List<String> result, int i, int k) {
		if (k == 0) {
			result.add(new String(arr));
			return;
		}
		if (i >= arr.length) {
			return;
		}
		if (arr[i - 1] == '0') {
			arr[i] = '0';
			generate(arr, result, i + 1, k - 1);
			arr[i] = '1';
			generate(arr, result, i + 1, k - 1);

		}
		else if (arr[i - 1] == '1') {
			arr[i] = '0';
			generate(arr, result, i + 1, k - 1);
		}
	}
}
