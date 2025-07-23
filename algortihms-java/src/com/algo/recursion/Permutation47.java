package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//description: https://leetcode.com/problems/permutations-ii/description/
public class Permutation47 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        List<List<Integer>> result = getPermutation(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> getPermutation(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
        List<Integer> perm = new ArrayList<>();
        permute(arr, perm, map, result);
        return result;
    }

    private static void permute(int[] arr, List<Integer> perm, Map<Integer, Integer> map,
                                List<List<Integer>> result) {
        if (perm.size() == arr.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int num : map.keySet()) {
            var count = map.get(num);
            if (count > 0) {
                --count;
                map.put(num, count);
                perm.add(num);
                permute(arr, perm, map, result);
                ++count;
                map.put(num, count);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
