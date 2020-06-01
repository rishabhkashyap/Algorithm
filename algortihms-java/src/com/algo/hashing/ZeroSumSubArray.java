package com.algo.hashing;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        //int[] arr = {4, 2, -3, 10, 6};
        System.out.println("Sub array with zero sum exist = " + zeroSumSubarrayExist(arr));
    }

    private static boolean zeroSumSubarrayExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int number : arr) {
            preSum += number;
            if (preSum == 0 || set.contains(preSum)) {
                return true;
            } else {
                set.add(preSum);
            }
        }
        return false;
    }
}
