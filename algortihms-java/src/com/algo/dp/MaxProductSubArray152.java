package com.algo.dp;

//Problem: https://leetcode.com/problems/maximum-product-subarray/description/

import java.util.Arrays;

public class MaxProductSubArray152 {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(findMaxProduct(arr));

    }

    private static int findMaxProduct(int[] arr) {
        var maxProduct = Arrays.stream(arr).max().getAsInt();
        var currMax = 1;
        var currMin = 1;
        for (var num : arr) {
            if (num == 0) {
                currMax = 1;
                currMin = 1;
            } else {
                var temp = currMax;
                currMax = Math.max(num, Math.max(currMax * num, currMin * num));
                currMin = Math.min(num, Math.min(temp * num, currMin * num));
                maxProduct = Math.max(maxProduct, currMax);
            }
        }
        return maxProduct;
    }
}
