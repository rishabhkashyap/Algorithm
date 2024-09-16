package com.algo.interval;

import java.util.Arrays;
import java.util.Comparator;

//Problem: https://leetcode.com/problems/non-overlapping-intervals/description/
public class NonOverlappingInterval435 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(findCountOfIntervalsToBeRemoved(arr));
    }

    private static int findCountOfIntervalsToBeRemoved(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));
        var prevEndTime = arr[0][1];
        var removedIntervals = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < prevEndTime) {
                //Larger end time means there are more chances that such interval will
                //overlap with other interval
                prevEndTime = Math.min(prevEndTime, arr[i][1]);
                ++removedIntervals;
            }
            if (arr[i][0] == prevEndTime) {
                prevEndTime = arr[i][1];
            }
        }
        return removedIntervals;
    }
}
