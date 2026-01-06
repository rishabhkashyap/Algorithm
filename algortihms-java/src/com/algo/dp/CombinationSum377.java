package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/combination-sum-iv/description/

public class CombinationSum377 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        var target = 4;
        System.out.println(findCombinations1(arr, target));
        System.out.println(findCombinations2(arr, target));
    }
    private static int findCombinations1(int[] arr, int target){
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return findCombinations1(arr, target, dp);
    }

    private static int findCombinations1(int[] arr, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        dp[target] = 0;
        //Loop is used because not only same value can be used again and again
        //but also duplicate combination like {1, 3} and {3, 1} are considered unique.
        //Once a element is selected in current call, array iteration begins from index 0
        //in next call.
        for (int num : arr) {
            dp[target] += findCombinations1(arr, target - num, dp);
        }
        return dp[target];
    }

    private static int findCombinations2(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : arr) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
