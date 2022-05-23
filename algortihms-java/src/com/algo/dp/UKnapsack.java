package com.algo.dp;

import java.util.Arrays;

public class UKnapsack {
    public static void main(String[] args) {
//        int w = 100;
//        int[] values = { 1, 30 };
//        int[] weights = { 1, 50 };
        int w = 8;
        int[] values = {10, 40, 50, 70};
        int[] weights = {1, 3, 4, 5};
        System.out.println("Max value = " + findMaxProfit1(w, weights, values));
        System.out.println("Max value = " + findMaxProfit2(w, weights, values));
    }

    private static int findMaxProfit1(int w, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][w + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findMaxProfit1(w, weights, values, values.length - 1, dp);
    }

    private static int findMaxProfit1(int w, int[] weights, int[] values, int i, int[][] dp) {
        if (i < 0 || w < 0) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        if (w < weights[i]) {
            return findMaxProfit1(w, weights, values, i - 1, dp);
        }
        int result1 = findMaxProfit1(w - weights[i], weights, values, i, dp) + values[i];
        int result2 = findMaxProfit1(w, weights, values, i - 1, dp);
        dp[i][w] = Math.max(result1, result2);
        return dp[i][w];
    }

    private static int findMaxProfit2(int w, int[] weights, int[] values) {
       int[][]dp=new int[weights.length+1][w+1];
       for(int i=1;i<=weights.length;i++){
           for(int j=1;j<=w;j++){
               if(j<weights[i-1]){
                   dp[i][j]=dp[i-1][j];
               }else {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-weights[i-1]]+values[i-1]);
               }
           }
       }
       return dp[weights.length][w];
    }
}
