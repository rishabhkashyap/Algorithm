package com.algo.recursion;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/combinations/description/
public class Combinations77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = getCombinations(n, k);
        System.out.println(result);
    }

    private static List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, 1, k, list, result);
        return result;
    }

    private static void helper(int n, int i, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            helper(n, j + 1, k, list, result);
            list.remove(list.size() - 1);
        }
    }
}
