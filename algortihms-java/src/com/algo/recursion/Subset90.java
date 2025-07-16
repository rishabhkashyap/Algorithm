package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/subsets-ii/description/
public class Subset90 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> result = generateSubsets(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        generateSubsets(arr, 0, list, result);
        return result;
    }

    private static void generateSubsets(int[] arr, int i, List<Integer> list, List<List<Integer>> result) {
        if (i >= arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        generateSubsets(arr, i + 1, list, result);
        list.remove(list.size() - 1);
        while(i + 1 < arr.length && arr[i] == arr[i + 1]){
            ++i;
        }
        generateSubsets(arr, i + 1, list, result);
    }
}
