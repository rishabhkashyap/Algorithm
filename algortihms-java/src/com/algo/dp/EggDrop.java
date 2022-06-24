package com.algo.dp;

import java.util.Arrays;

public class EggDrop {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;
        System.out.println("Number of trials = " + findTrialCount(eggs, floors));
    }

    private static int findTrialCount(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findTrialCount(eggs, floors, dp);
    }


    private static int findTrialCount(int eggs, int floors, int[][] dp) {
        if (eggs == 0) {
            return 0;
        }
        if (floors == 0 || floors == 1) {
            return floors;
        }
        //start from floor 1 then floor 2 and so on. Worst case scenario egg doesn't break
        //till top floor therefore number of trial required is equal to number of floors
        if (eggs == 1) {
            return floors;
        }
        if (dp[eggs][floors] != -1) {
            return dp[eggs][floors];
        }
        int minTrials = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int result = Math.max(findTrialCount(eggs - 1, i - 1, dp),
                    findTrialCount(eggs, floors - i, dp))+1;
            minTrials = Math.min(minTrials, result);
        }
        dp[eggs][floors] = minTrials;
        return dp[eggs][floors];
    }
}
