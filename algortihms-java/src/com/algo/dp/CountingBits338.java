package com.algo.dp;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/counting-bits/description/

public class CountingBits338 {
    public static void main(String[] args) {
        var n = 5;
        int[] result = countBits(n);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
    //If ( i ) is even, the number of 1s in ( i ) is the same as the number of 1s in ( i/2 )
    // (right-shifting an even number halves it without adding a new 1).
    //If ( i ) is odd, the number of 1s in ( i ) is the number of 1s in ( i - 1 )
    // plus one additional 1 (as adding 1 to an even number makes it odd).

    private static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }


}
