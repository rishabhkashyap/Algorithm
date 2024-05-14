package com.algo.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class KSmallestPairs373 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int[] arr2 = {1, 2, 3};
//		int[] arr1 = { 1, 7, 11 };
//		int[] arr2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(findKSmallestPairs(arr1, arr2, k));


    }

    private static List<List<Integer>> findKSmallestPairs(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(e -> (arr1[e.index1] + arr2[e.index2])));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            priorityQueue.add(new Pair(i, 0));
        }
        while (k > 0 && !priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.remove();
            result.add(List.of(arr1[pair.index1], arr2[pair.index2]));
            --k;
            if (pair.index2 + 1 < arr2.length) {
                priorityQueue.add(new Pair(pair.index1, pair.index2 + 1));
            }
        }
        return result;
    }

    private record Pair(
            Integer index1,
            Integer index2
    ) {
    }


}
