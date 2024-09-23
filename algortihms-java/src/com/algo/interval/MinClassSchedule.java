package com.algo.interval;

import java.util.Arrays;

public class MinClassSchedule {
    public static void main(String[] args) {
        // int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        // int[][] arr={{0, 5}, {1, 2}, {1, 10}};
        int[][] arr = {{0, 5}, {1, 2}, {6, 10}};
        System.out.println(findMinClass(arr));
    }

    private static int findMinClass(int[][] arr) {
        int[] start = new int[arr.length];
        int[] end = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        var result = Integer.MIN_VALUE;
        var count = 0;
        var i = 0;
        var j = 0;
        while (i < arr.length && j < arr.length) {
            if (start[i] < end[j]) {
                //Meeting already in progress.
                ++count;
                ++i;
            } else {
                //when start and end time are equal
                ++j;
                --count;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
