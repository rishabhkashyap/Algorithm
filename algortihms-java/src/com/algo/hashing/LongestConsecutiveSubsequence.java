package com.algo.hashing;

import java.util.*;

//Problem: https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        //  int[] arr = {10, 3, 20, 1, 2, 4};
        //  int[] arr = {1, 2, 0, 1};
        System.out.println("Longest consecutive subsequence = " + findMaxLengthSubsequence(arr));
        System.out.println("Longest consecutive subsequence = " + findMaxLengthSubsequence2(arr));
    }

    private static int findMaxLengthSubsequence(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        for (int ele : nums) {
            if (!set.contains(ele - 1)) {
                int count = 0;
                int start = ele;
                while (set.contains(start)) {
                    ++count;
                    ++start;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    //Using sorting
    public static int findMaxLengthSubsequence2(int[] arr) {
        int result = 0;
        Arrays.sort(arr);
        int count = 1;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) + 1) {
                ++count;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;

    }


}
