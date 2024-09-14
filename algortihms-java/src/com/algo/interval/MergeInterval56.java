package com.algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.sort(arr, (e1, e2) -> e1[0] - e2[0]);
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{arr[0][0], arr[0][1]});
        for (int i = 1; i < arr.length; i++) {
            var interval = result.get(result.size() - 1);
            //check if start of new interval is less than end of previous interval
            if (arr[i][0] <= interval[1]) {
                //Take max end time to deal with following case
                //consider 2 intervals [1,6] [2,4]
                //when they are merged new interval will be [1,6], therefore taking max end time
                interval[1] = Math.max(interval[1], arr[i][1]);
            } else {
                result.add(new int[]{arr[i][0], arr[i][1]});
            }
        }
        int[][] mergedInterval = new int[result.size()][];
        int i = 0;
        for (int[] interval : result) {
            mergedInterval[i++] = interval;
        }
        return mergedInterval;
    }

}
