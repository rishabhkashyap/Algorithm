package com.algo.greedy;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/jump-game-ii/
public class JumpGame45 {
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
    //Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the
    // farthest point that all points in [curBegin, curEnd] can reach. Once the current
    // point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest
    private static int minJumps2(int[] arr){
        var curEnd=0;
        var farthestPoint=0;
        var jumps=0;
        for (var i = 0; i < arr.length - 1; i++) {
            farthestPoint=Math.max(farthestPoint,i+arr[i]);
            if(i==curEnd){
                ++jumps;
                curEnd=farthestPoint;
            }
        }
        return jumps;
    }
}
