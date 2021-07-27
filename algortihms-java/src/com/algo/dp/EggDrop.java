package com.algo.dp;

public class EggDrop {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;
        System.out.println("Number of trials = " + findTrialCount(eggs, floors));
    }

    private static int findTrialCount(int eggs, int floors) {
        if (eggs == 0) {
            return 0;
        }
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }
        int minTrials = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int result = Math.max(findTrialCount(eggs - 1, i - 1),
                    findTrialCount(eggs, floors - i));
            minTrials = Math.min(minTrials, result);
        }
        return minTrials + 1;
    }
}
