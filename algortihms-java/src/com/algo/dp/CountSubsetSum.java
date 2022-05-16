package com.algo.dp;

public class CountSubsetSum {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 3};
//        int target = 6;
        int[] arr={1,1,1,1};
        int target=1;
        System.out.println(countSubsets(arr, target));
    }

    private static int countSubsets(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        dp[0][0]=1;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][0] = 1;
                } else if(i==0 && j>0){
                    dp[0][j]=0;
                }else {
                    if (j < arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                    }
                }

            }
        }
        return dp[arr.length][target];
    }
}
