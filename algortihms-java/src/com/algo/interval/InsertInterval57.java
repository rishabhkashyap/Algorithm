package com.algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval57 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {6, 9}};
        int[] interval = {2, 5};
//        int[][] arr = {{1, 5}};
//        int[] interval = {2, 3};
        // int[][] result = insertInterval1(arr, interval);
//        for (int[] temp : result) {
//            System.out.print("[" + temp[0] + "," + temp[1] + "]");
//        }
//        int[][] result = insertInterval2(arr, interval);
//        for (int[] temp : result) {
//            System.out.print("[" + temp[0] + "," + temp[1] + "]");
//        }
        int[][] result = insertInterval3(arr, interval);
        for (int[] temp : result) {
            System.out.print("[" + temp[0] + "," + temp[1] + "]");
        }
    }

    //Add new interval to array, sort array and merge all intervals
    //This approach does not take advantage of the fact that array of
    //intervals is already sorted
    private static int[][] insertInterval1(int[][] arr, int[] interval) {
        if (arr.length == 0) {
            return new int[][]{interval};
        }
        int[][] temp = new int[arr.length + 1][];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[arr.length] = interval;
        Arrays.sort(temp, Comparator.comparingInt(e -> e[0]));
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{temp[0][0], temp[0][1]});
        for (int i = 1; i < temp.length; i++) {
            var prev = result.get(result.size() - 1);
            if (temp[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], temp[i][1]);
            } else {
                result.add(new int[]{temp[i][0], temp[i][1]});
            }
        }
        temp = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        return temp;
    }

    private static int[][] insertInterval2(int[][] arr, int[] interval) {
        if (arr.length == 0) {
            return new int[][]{interval};
        }
        List<int[]> result = new ArrayList<>();
        var i = 0;
        while (i < arr.length) {
            if (interval[1] < arr[i][0]) {
                result.add(interval);
                break;
            } else if (interval[0] > arr[i][1]) {
                result.add(arr[i]);
            } else {
                interval = new int[]{Math.min(interval[0], arr[i][0]), Math.max(interval[1], arr[i][1])};
            }
            ++i;
        }
        //Deals with edge case where array contains only one interval, and it's overlapping
        //with interval that has to be inserted
        if (i == arr.length) {
            result.add(interval);
        }
        while (i < arr.length) {
            result.add(arr[i]);
            ++i;
        }
        return result.toArray(new int[result.size()][]);
    }

    //Most intuitive solution
    private static int[][] insertInterval3(int[][] arr, int[] interval) {
        if (arr.length == 0) {
            return new int[][]{interval};
        }
        List<int[]> result = new ArrayList<>();
        var i = 0;
        //insert all intervals that end before new interval starts
        while (i < arr.length && arr[i][1] < interval[0]) {
            result.add(new int[]{arr[i][0], arr[i][1]});
            ++i;
        }
        //Merge overlapping intervals ie any interval that starts
        //before new interval ends
        while (i < arr.length && interval[1] >= arr[i][0]) {
            interval[0] = Math.min(interval[0], arr[i][0]);
            interval[1] = Math.max(interval[1], arr[i][1]);
            ++i;
        }
        result.add(interval);
        //Add intervals that start after new interval ends
        while (i < arr.length) {
            result.add(new int[]{arr[i][0], arr[i][1]});
            ++i;
        }
        return result.toArray(new int[result.size()][]);


    }
}
