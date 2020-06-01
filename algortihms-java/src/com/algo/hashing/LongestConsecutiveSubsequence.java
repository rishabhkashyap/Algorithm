package com.algo.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        //int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int arr[] = {10,3,20,1,2,4};
        System.out.println("Longest consecutive subsequence = " + findMaxLengthSubsequence(arr));
    }

    private static int findMaxLengthSubsequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(e -> set.add(e));
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i] - 1)) {
                int element = arr[i];
                j = i;
                while (set.contains(element++)) {
                    ++j;
                }
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }


}
