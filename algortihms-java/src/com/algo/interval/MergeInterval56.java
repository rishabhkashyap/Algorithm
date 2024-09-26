package com.algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Problem: https://leetcode.com/problems/merge-intervals/description/
public class MergeInterval56 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeInterval(arr);
        for (int[] pair : result) {
            System.out.print("[" + pair[0] + " " + pair[1] + "]  ");
        }

    }

    private static int[][] mergeInterval(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));
        List<int[]> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            var interval = result.get(result.size() - 1);
            //check if start of new interval is less than end of previous interval
            if (arr[i][0] <= interval[1]) {
                //Take max end time to deal with following case
                //consider 2 intervals [1,6] [2,4]
                //when they are merged new interval will be [1,6], therefore taking max end time
                interval[1] = Math.max(interval[1], arr[i][1]);
            } else {
                result.add(arr[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
