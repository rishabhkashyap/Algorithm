package com.algo.dp;

import java.util.Arrays;

public class SubsetWithDiff {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 3};
//        int diff = 1;
        int[] arr = {1, 6, 11, 5};
        int diff = 1;
        System.out.println(countWays2(arr, diff));

    }

    private static int countWays2(int[] arr, int target) {
        int sum = Arrays.stream(arr).sum();
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }
        //sum(p1) - sum(p2)=diff(differnce of sum of 2 partitions of array)
        //sum(p1) + sum(p2)=sum(sum of all elements in array)
        //solving 2 equation will give following result
        //sum(p1)=(diff+sum)/2
        //Problem boils down to find count of subset whose sum is equal to sum(p1)
        int partitionSum = (sum + target) / 2;
        int[][] dp = new int[arr.length + 1][partitionSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= partitionSum; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }

                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][partitionSum];

    }
}
