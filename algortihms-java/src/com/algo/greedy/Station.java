package com.algo.greedy;

import java.util.Arrays;

public class Station {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum number of stations required = " +
                findMinStations(arr, dep));
    }

    private static int findMinStations(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int stationCount = 1;
        //Start with second arrival time
        int i = 1;
        int j = 0;
        while (i < arr.length) {
            if (j < dep.length && arr[i] < dep[j]) {
                ++stationCount;
            } else {
                ++j;
            }
            ++i;
        }
        return stationCount;
    }
}
