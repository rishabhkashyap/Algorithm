package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//description: https://leetcode.com/problems/permutations/description/
public class Permutation46 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = getPermutations1(arr);
        System.out.println(result);
        result.clear();
        System.out.println();
        result = getPermutation2(arr);
        System.out.println(result);
    }

    //Time complexity of both approach is O(N * N!) where N is length of array.

    private static List<List<Integer>> getPermutations1(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(arr, list, result);
        return result;
    }

    private static void helper(int[] arr, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (!list.contains(arr[j])) {
                list.add(arr[j]);
                helper(arr, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private static List<List<Integer>> getPermutation2(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutation2(arr, 0, result);
        return result;
    }

    private static void getPermutation2(int[] arr, int i, List<List<Integer>> result) {
        if (i == arr.length) {
            var permutation = Arrays.stream(arr)
                    .boxed()
                    .toList();
            result.add(permutation);
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            getPermutation2(arr, i + 1, result);
            swap(arr, j, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
