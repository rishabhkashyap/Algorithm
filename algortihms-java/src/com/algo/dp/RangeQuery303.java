package com.algo.dp;

//Problem: https://leetcode.com/problems/range-sum-query-immutable/description/

public class RangeQuery303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
    }

    private static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] nums) {
            this.prefixSum = new int[nums.length];
            var sum = 0;
            var i = 0;
            for (int num : nums) {
                sum += num;
                prefixSum[i++] = sum;
            }
        }

        public int sumRange(int left, int right) {
            var rightSum = prefixSum[right];
            var leftSum = left > 0 ? prefixSum[left - 1] : 0;
            return rightSum - leftSum;
        }
    }
}
