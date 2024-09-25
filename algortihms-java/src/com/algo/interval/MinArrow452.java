package com.algo.interval;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrow452 {

    public static void main(String[] args) {
        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findArrowCount(arr));
    }

    private static int findArrowCount(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));
        int[] prevInterval = arr[0];
        var count = arr.length;
        for (int i = 1; i < arr.length; i++) {
            if (prevInterval[1] >= arr[i][0]) {
                //Pick bigger equal  start time and smaller end time
                //We update prev interval with an interval that is
                //overlapping previous and current interval. If subsequent interval
                //overlap this overlapping interval merge then no additional arrow is needed
                prevInterval[0] = arr[i][0];
                prevInterval[1] = Math.min(prevInterval[1], arr[i][1]);
                --count;
            } else {
                prevInterval = arr[i];
            }

        }
        return count;
    }

}
