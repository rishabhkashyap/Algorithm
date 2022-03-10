package com.algo.greedy;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/jump-game-ii/submissions/
public class Jump45 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};

        System.out.println(minJumps1(arr));
        System.out.println(minJumps2(arr));
    }

    //DP solution
    private static int minJumps1(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return minJumps1(arr, 0, dp);
    }

    private static int minJumps1(int[] arr, int i, int[] dp) {
        if (i >= arr.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 100001;
        for (int j = 1; j <= arr[i]; j++) {
            dp[i] = Math.min(dp[i], minJumps1(arr, i + j, dp) + 1);

        }
        return dp[i];
    }


    //Greedy solution
    public static int minJumps2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int nextMaxJumpIndex = 0;
        int currentJumpIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //Find out max jump that is possible from current index
            nextMaxJumpIndex = Math.max(nextMaxJumpIndex, i + nums[i]);
            if (nextMaxJumpIndex >= nums.length - 1) {
                return ++count;
            }
            //once we  reach to max jump we took earlier we will update it to the max
            //jump that we found later ie  nextMaxJumpIndex
            if (i == currentJumpIndex) {
                ++count;
                currentJumpIndex = nextMaxJumpIndex;
                nextMaxJumpIndex = 0;
            }
        }
        return count;

    }
}
